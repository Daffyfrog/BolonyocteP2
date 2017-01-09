package bolonyocte.com.bolonyocteproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.List;

/**
 * Created by iem on 05/01/2017.
 */

public class ZoneDeVie {

    int codeZoneDeVie;
    String nomZoneDeVie;
    int potentielConsommation;
    String potentielConcurrentiel;
    List<Commune> communes;
    @JsonIgnore
    List<Enseigne> enseignes;
    HashMap<String,Double> stats;

    public ZoneDeVie() {
    }

    public ZoneDeVie(String nomZoneDeVie, int codeZoneDeVie, int potentielConsommation, String potentielConcurrentiel) {
        this.nomZoneDeVie = nomZoneDeVie;
        this.codeZoneDeVie = codeZoneDeVie;
        this.potentielConsommation = potentielConsommation;
        this.potentielConcurrentiel = potentielConcurrentiel;
    }


    public ZoneDeVie(int codeZoneDeVie, String nomZoneDeVie, int potentielConsommation, String potentielConcurrentiel, List<Commune> communes, List<Enseigne> enseignes, HashMap<String, Double> stats) {
        this.codeZoneDeVie = codeZoneDeVie;
        this.nomZoneDeVie = nomZoneDeVie;
        this.potentielConsommation = potentielConsommation;
        this.potentielConcurrentiel = potentielConcurrentiel;
        this.communes = communes;
        this.enseignes = enseignes;
        this.stats = stats;
    }

    public ZoneDeVie(int codeZoneDeVie, String nomZoneDeVie, int potentielConsommation, String potentielConcurrentiel, List<Commune> communes, HashMap<String, Double> stats) {
        this.codeZoneDeVie = codeZoneDeVie;
        this.nomZoneDeVie = nomZoneDeVie;
        this.potentielConsommation = potentielConsommation;
        this.potentielConcurrentiel = potentielConcurrentiel;
        this.communes = communes;
        this.stats = stats;
    }

    public int getCodeZoneDeVie() {
        return codeZoneDeVie;
    }

    public void setCodeZoneDeVie(int codeZoneDeVie) {
        this.codeZoneDeVie = codeZoneDeVie;
    }

    public String getNomZoneDeVie() {
        return nomZoneDeVie;
    }

    public void setNomZoneDeVie(String nomZoneDeVie) {
        this.nomZoneDeVie = nomZoneDeVie;
    }

    public int getPotentielConsommation() {
        return potentielConsommation;
    }

    public void setPotentielConsommation(int potentielConsommation) {
        this.potentielConsommation = potentielConsommation;
    }

    public String getPotentielConcurrentiel() {
        return potentielConcurrentiel;
    }

    public void setPotentielConcurrentiel(String potentielConcurrentiel) {
        this.potentielConcurrentiel = potentielConcurrentiel;
    }

    public List<Commune> getCommunes() {
        return communes;
    }

    public void setCommunes(List<Commune> communes) {
        this.communes = communes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZoneDeVie zoneDeVie = (ZoneDeVie) o;

        if (codeZoneDeVie != zoneDeVie.codeZoneDeVie) return false;
        if (potentielConsommation != zoneDeVie.potentielConsommation) return false;
        if (nomZoneDeVie != null ? !nomZoneDeVie.equals(zoneDeVie.nomZoneDeVie) : zoneDeVie.nomZoneDeVie != null)
            return false;
        if (potentielConcurrentiel != null ? !potentielConcurrentiel.equals(zoneDeVie.potentielConcurrentiel) : zoneDeVie.potentielConcurrentiel != null)
            return false;
        return communes != null ? communes.equals(zoneDeVie.communes) : zoneDeVie.communes == null;

    }

    @Override
    public int hashCode() {
        int result = codeZoneDeVie;
        result = 31 * result + (nomZoneDeVie != null ? nomZoneDeVie.hashCode() : 0);
        result = 31 * result + potentielConsommation;
        result = 31 * result + (potentielConcurrentiel != null ? potentielConcurrentiel.hashCode() : 0);
        result = 31 * result + (communes != null ? communes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ZoneDeVie{" +
                "codeZoneDeVie=" + codeZoneDeVie +
                ", nomZoneDeVie='" + nomZoneDeVie + '\'' +
                ", potentielConsommation=" + potentielConsommation +
                ", potentielConcurrentiel='" + potentielConcurrentiel + '\'' +
                ", communes=" + communes +
                ", enseignes=" + enseignes +
                ", stats=" + stats +
                '}';
    }
}
