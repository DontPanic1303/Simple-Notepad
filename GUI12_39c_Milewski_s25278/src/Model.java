import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Model {

    private String[] stan={"new","modified","saved"};;
    private File plik = null;
    private Icon icon1 =null;
    private Icon icon2 =null;
    private Color ci1;
    private Color oci1;
    private Color ci2;
    private Color oci2;


    Model(){
    }

    public void setIcon1(){
        icon1 = new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                g.setColor(oci1);
                g.fillOval(1,3,10,10);
            }

            @Override
            public int getIconWidth() {
                return 0;
            }

            @Override
            public int getIconHeight() {
                return 0;
            }
        };
    }

    public void setIcon2(){
        icon2 = new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                g.setColor(oci2);
                g.fillOval(1,3,10,10);
            }

            @Override
            public int getIconWidth() {
                return 0;
            }

            @Override
            public int getIconHeight() {
                return 0;
            }
        };
    }

    public File getPlik() {
        return plik;
    }

    public void setPlik(File plik) {
        this.plik = plik;
    }

    public String[] getStan() {
        return stan;
    }

    public Color getCi1() {
        return ci1;
    }

    public Color getCi2() {
        return ci2;
    }

    public void setCi1(Color ci1) {
        this.oci1=this.ci1;
        this.ci1 = ci1;
    }

    public void setCi2(Color ci2) {
        this.oci2=this.ci2;
        this.ci2 = ci2;
    }

    public Icon getIcon1() {
        return icon1;
    }

    public Icon getIcon2() {
        return icon2;
    }
}
