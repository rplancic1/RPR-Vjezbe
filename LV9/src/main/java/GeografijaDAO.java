import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GeografijaDAO {
    private static GeografijaDAO instance;
    private Connection conn;
    private PreparedStatement glavniGradUpit,dajDrzavuUpit,obrisiGradUpit, sacuvajPromjeneUpit, obrisiDrzavuUpit, vratiGradoveUpit, vratiDrzavuUpit,
            dodajGradUpit, dodajDrzavuUpit, vratiMaxIDGradUpit, vratiMaxIDDrzavaUpit, izmijeniGradUpit, nadjiDrzavuUpit;;
    public static GeografijaDAO getInstance(){
        if(instance==null) instance=new GeografijaDAO();
        return instance;
    }
    private GeografijaDAO(){
        try {
            conn= DriverManager.getConnection("jdbc:sqlite:baza.db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            dajDrzavuUpit=conn.prepareStatement("SELECT * FROM drzava WHERE id=?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            glavniGradUpit= conn.prepareStatement("SELECT id, naziv, broj_stanovnika FROM grad WHERE drzava=?");
            obrisiGradUpit=conn.prepareStatement("DELETE FROM grad WHERE drzava=?");
            sacuvajPromjeneUpit= conn.prepareStatement("COMMIT");
            obrisiDrzavuUpit=conn.prepareStatement("DELETE FROM drzava WHERE naziv=?");
            vratiGradoveUpit=conn.prepareStatement("SELECT id, naziv, broj_stanovnika FROM grad ORDER BY broj_stanovnika DESC");
            vratiDrzavuUpit=conn.prepareStatement("SELECT id, naziv, glavni_grad FROM drzava WHERE glavni_grad=?");
            dodajGradUpit=conn.prepareStatement("INSERT INTO grad VALUES(?,?,?,?)");
            dodajDrzavuUpit=conn.prepareStatement("INSERT INTO drzava VALUES(?,?,?)");
            vratiMaxIDGradUpit =conn.prepareStatement("SELECT MAX(id) FROM grad");
            vratiMaxIDDrzavaUpit =conn.prepareStatement("SELECT MAX(id) FROM drzava");
            izmijeniGradUpit= conn.prepareStatement("UPDATE grad SET naziv=?, broj_stanovnika=?, drzava=? WHERE id=?");
            nadjiDrzavuUpit=conn.prepareStatement("SELECT id, naziv, glavni_grad FROM drzava WHERE naziv=?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void removeInstance() {
        if(instance==null) return;
        try {
            instance.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        instance=null;
    }
    private void regenerisiBazu() {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileInputStream("baza.db.sql"));
            String sqlUpit="";
            while (ulaz.hasNext()){
                sqlUpit+=ulaz.nextLine();
                if(sqlUpit.charAt(sqlUpit.length()-1)==';')
                {
                    try {
                        Statement stat=conn.createStatement();
                        stat.execute(sqlUpit);
                        sqlUpit="";
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                ulaz.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public Grad glavniGrad(String drzava) {
        try {
            glavniGradUpit.setString(1, drzava);
            ResultSet rs = glavniGradUpit.executeQuery();
            if(!rs.next()) return null;
            return dajGradIzResultSeta(rs);
        } catch (SQLException e) {
            return null;
        }
    }
    private Grad dajGradIzResultSeta(ResultSet rs) throws SQLException {
        Grad grad= new Grad(rs.getInt(1),rs.getString(2),rs.getInt(3),null);
        grad.setDrzava(dajDrzavu(rs.getInt(4),grad));
        return grad;
    }
    private Drzava dajDrzavu(int id,Grad grad) {
        try {
            dajDrzavuUpit.setInt(1,id);
            ResultSet rs = dajDrzavuUpit.executeQuery();
            if(!rs.next()) return null;
            return dajDrzavuIzResultSeta(rs,grad);
        } catch (SQLException e) {
            return null;
        }
    }
    private Drzava dajDrzavuIzResultSeta(ResultSet rs,Grad grad) throws SQLException {
        return new Drzava(rs.getInt(1),rs.getString(2),grad);
    }
    void obrisiDrzavu(String drzava) {
        try {
            dajDrzavuUpit.setString(1,drzava);
            ResultSet rs = dajDrzavuUpit.executeQuery();
            if(!rs.next()) return;

            glavniGradUpit.setInt(1, rs.getInt(1));
            rs= glavniGradUpit.executeQuery();
            if(!rs.next())throw new NullPointerException("NE POSTOJI");
            obrisiGradUpit.setInt(1, rs.getInt(1));
            obrisiGradUpit.execute();
            while(rs.next())
                obrisiGradUpit.execute();

            obrisiDrzavuUpit.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Grad> gradovi() {
        ArrayList<Grad> rezultat = new ArrayList<>();
        try {
            ResultSet rs= vratiGradoveUpit.executeQuery();
            while(rs.next()){
                Grad grad=new Grad();
                grad.setId(rs.getInt(1));
                grad.setNaziv(rs.getString(2));
                grad.setBrojStanovnika(3);
                vratiDrzavu(grad);
                rezultat.add(grad);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rezultat;
    }
    private void vratiDrzavu(Grad grad) {
        Drzava drzava = new Drzava();
        try {
            vratiDrzavuUpit.setInt(1,grad.getId());
            ResultSet rs=vratiDrzavuUpit.executeQuery();
            rs.next();
            drzava.setId(rs.getInt(1));
            drzava.setNaziv(rs.getString(2));
            drzava.setGlavniGrad(grad);
            grad.setDrzava(drzava);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void dodajGrad(Grad grad){
        try {
            ResultSet rs = vratiMaxIDGradUpit.executeQuery();
            int id=1;
            if(rs.next()) id=rs.getInt(1)+1;
            grad.setId(id);
            dodajGradUpit.setInt(1, id);
            dodajGradUpit.setString(2, grad.getNaziv());
            dodajGradUpit.setInt(3, grad.getBrojStanovnika());
            dodajGradUpit.setInt(4, grad.getDrzava().getId());
            dodajGradUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    void dodajDrzavu(Drzava drzava){
        try {
            ResultSet rs=vratiMaxIDDrzavaUpit.executeQuery();
            int id=1;
            if(rs.next())id=rs.getInt(1)+1;
            drzava.setId(id);
            dodajDrzavuUpit.setInt(1, id);
            dodajDrzavuUpit.setString(2, drzava.getNaziv());
            dodajDrzavuUpit.setInt(3, drzava.getGlavniGrad().getId());
            dodajDrzavuUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    void izmijeniGrad(Grad grad){
        try {
            izmijeniGradUpit.setString(1, grad.getNaziv());
            izmijeniGradUpit.setInt(2, grad.getBrojStanovnika());
            izmijeniGradUpit.setInt(3, grad.getDrzava().getId());
            izmijeniGradUpit.setInt(4, grad.getId());
            izmijeniGradUpit.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    Drzava nadjiDrzavu(String drzava){
        Drzava rezultat = new Drzava();
        try {
            nadjiDrzavuUpit.setString(1, drzava);
            ResultSet rs = nadjiDrzavuUpit.executeQuery();
            if(!rs.next()) return null;

            rezultat.setId(rs.getInt(1));
            rezultat.setNaziv(rs.getString(2));
            postaviGrad(rezultat);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rezultat;
    }
    private void postaviGrad(Drzava drzava) {
        Grad grad = new Grad();
        try {
            glavniGradUpit.setInt(1, drzava.getId());
            ResultSet rs = glavniGradUpit.executeQuery();
            grad.setId(rs.getInt(1));
            grad.setNaziv(rs.getString(2));
            grad.setBrojStanovnika(rs.getInt(3));
            grad.setDrzava(drzava);
            drzava.setGlavniGrad(grad);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}