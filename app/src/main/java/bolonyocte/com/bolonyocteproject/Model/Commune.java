package bolonyocte.com.bolonyocteproject.Model;

import java.util.List;

/**
 * Created by iem on 05/01/2017.
 */

public class Commune {

    int codeCommune;
    String nomCommune;
    List<Enseigne> enseignes;




    public Commune(){

    }

    public Commune(int codeCommune, String nomCommune, List<Enseigne> enseignes) {
        this.codeCommune = codeCommune;
        this.nomCommune = nomCommune;
        this.enseignes = enseignes;
    }

    public Commune(int codeCommune, String nomCommune) {
        this.codeCommune = codeCommune;
        this.nomCommune = nomCommune;
    }

    public int getCodeCommune() {
        return codeCommune;
    }

    public void setCodeCommune(int codeCommune) {
        this.codeCommune = codeCommune;
    }

    public List<Enseigne> getEnseignes() {
        return enseignes;
    }

    public void setEnseignes(List<Enseigne> enseignes) {
        this.enseignes = enseignes;
    }

    public String getNomCommune() {
        return nomCommune;
    }

    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commune commune = (Commune) o;

        if (codeCommune != commune.codeCommune) return false;
        if (nomCommune != null ? !nomCommune.equals(commune.nomCommune) : commune.nomCommune != null)
            return false;
        return enseignes != null ? enseignes.equals(commune.enseignes) : commune.enseignes == null;

    }

    @Override
    public int hashCode() {
        int result = codeCommune;
        result = 31 * result + (nomCommune != null ? nomCommune.hashCode() : 0);
        result = 31 * result + (enseignes != null ? enseignes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Commune{" +
                "codeCommune=" + codeCommune +
                ", nomCommune='" + nomCommune + '\'' +
                ", enseignes=" + enseignes +
                '}';
    }
}
