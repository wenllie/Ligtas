package com.example.ligtas.ui.monitorHealth;

public class SelfAssessmentHelper {

    boolean achesAndPains, diarrhea, dryCough, fatigue, fever, lossTasteAndSmell, headAche, runnyNose, shortnessOfBreath, soreThroat, noneOfTheAbove;

    public SelfAssessmentHelper() {

    }

    public SelfAssessmentHelper(boolean achesAndPains, boolean diarrhea, boolean dryCough, boolean fatigue, boolean fever, boolean lossTasteAndSmell, boolean headAche, boolean runnyNose, boolean shortnessOfBreath, boolean soreThroat, boolean noneOfTheAbove) {
        this.achesAndPains = achesAndPains;
        this.diarrhea = diarrhea;
        this.dryCough = dryCough;
        this.fatigue = fatigue;
        this.fever = fever;
        this.lossTasteAndSmell = lossTasteAndSmell;
        this.headAche = headAche;
        this.runnyNose = runnyNose;
        this.shortnessOfBreath = shortnessOfBreath;
        this.soreThroat = soreThroat;
        this.noneOfTheAbove = noneOfTheAbove;
    }

    public boolean isAchesAndPains() {
        return achesAndPains;
    }

    public void setAchesAndPains(boolean achesAndPains) {
        this.achesAndPains = achesAndPains;
    }

    public boolean isDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public boolean isDryCough() {
        return dryCough;
    }

    public void setDryCough(boolean dryCough) {
        this.dryCough = dryCough;
    }

    public boolean isFatigue() {
        return fatigue;
    }

    public void setFatigue(boolean fatigue) {
        this.fatigue = fatigue;
    }

    public boolean isFever() {
        return fever;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public boolean isLossTasteAndSmell() {
        return lossTasteAndSmell;
    }

    public void setLossTasteAndSmell(boolean lossTasteAndSmell) {
        this.lossTasteAndSmell = lossTasteAndSmell;
    }

    public boolean isHeadAche() {
        return headAche;
    }

    public void setHeadAche(boolean headAche) {
        this.headAche = headAche;
    }

    public boolean isRunnyNose() {
        return runnyNose;
    }

    public void setRunnyNose(boolean runnyNose) {
        this.runnyNose = runnyNose;
    }

    public boolean isShortnessOfBreath() {
        return shortnessOfBreath;
    }

    public void setShortnessOfBreath(boolean shortnessOfBreath) {
        this.shortnessOfBreath = shortnessOfBreath;
    }

    public boolean isSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public boolean isNoneOfTheAbove() {
        return noneOfTheAbove;
    }

    public void setNoneOfTheAbove(boolean noneOfTheAbove) {
        this.noneOfTheAbove = noneOfTheAbove;
    }
}
