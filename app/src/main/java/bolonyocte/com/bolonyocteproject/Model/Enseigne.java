package bolonyocte.com.bolonyocteproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by iem on 05/01/2017.
 */

public class Enseigne {

    int codePointDeVente;
    String nomEnseigne;
    String typeGSA;
    double latitude;
    double longitude;
    @JsonIgnore
    LatLng position;

    public Enseigne(){

    }

    public Enseigne(int codePointDeVente, String nomEnseigne, String typeGSA, LatLng position) {
        this.codePointDeVente = codePointDeVente;
        this.nomEnseigne = nomEnseigne;
        this.typeGSA = typeGSA;
        this.position = position;
    }

    public Enseigne(int codePointDeVente, String nomEnseigne, String typeGSA, double latitude, double longitude) {
        this.codePointDeVente = codePointDeVente;
        this.nomEnseigne = nomEnseigne;
        this.typeGSA = typeGSA;
        this.latitude = latitude;
        this.longitude = longitude;
        position = new LatLng(latitude,longitude);
    }

    public int getCodePointDeVente() {
        return codePointDeVente;
    }

    public void setCodePointDeVente(int codePointDeVente) {
        this.codePointDeVente = codePointDeVente;
    }

    public String getNomEnseigne() {
        return nomEnseigne;
    }

    public void setNomEnseigne(String nomEnseigne) {
        this.nomEnseigne = nomEnseigne;
    }

    public String getTypeGSA() {
        return typeGSA;
    }

    public void setTypeGSA(String typeGSA) {
        this.typeGSA = typeGSA;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LatLng getPosition() {
        return position;
    }

    public void setPosition(LatLng position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enseigne enseigne = (Enseigne) o;

        if (codePointDeVente != enseigne.codePointDeVente) return false;
        if (Double.compare(enseigne.latitude, latitude) != 0) return false;
        if (Double.compare(enseigne.longitude, longitude) != 0) return false;
        if (nomEnseigne != null ? !nomEnseigne.equals(enseigne.nomEnseigne) : enseigne.nomEnseigne != null)
            return false;
        if (typeGSA != null ? !typeGSA.equals(enseigne.typeGSA) : enseigne.typeGSA != null)
            return false;
        return position != null ? position.equals(enseigne.position) : enseigne.position == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = codePointDeVente;
        result = 31 * result + (nomEnseigne != null ? nomEnseigne.hashCode() : 0);
        result = 31 * result + (typeGSA != null ? typeGSA.hashCode() : 0);
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Enseigne{" +
                "codePointDeVente=" + codePointDeVente +
                ", nomEnseigne='" + nomEnseigne + '\'' +
                ", typeGSA='" + typeGSA + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", position=" + position +
                '}';
    }
}
