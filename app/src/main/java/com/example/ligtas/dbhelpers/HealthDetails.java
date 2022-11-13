package com.example.ligtas.dbhelpers;

public class HealthDetails {

    String height, weight, covid19Vaccinated, covid19Vaccine, comorbidity, comorbidityName;

    public HealthDetails() {

    }

    public HealthDetails(String height, String weight, String covid19Vaccinated, String covid19Vaccine, String comorbidity, String comorbidityName) {
        this.height = height;
        this.weight = weight;
        this.covid19Vaccinated = covid19Vaccinated;
        this.covid19Vaccine = covid19Vaccine;
        this.comorbidity = comorbidity;
        this.comorbidityName = comorbidityName;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCovid19Vaccinated() {
        return covid19Vaccinated;
    }

    public void setCovid19Vaccinated(String covid19Vaccinated) {
        this.covid19Vaccinated = covid19Vaccinated;
    }

    public String getCovid19Vaccine() {
        return covid19Vaccine;
    }

    public void setCovid19Vaccine(String covid19Vaccine) {
        this.covid19Vaccine = covid19Vaccine;
    }

    public String getComorbidity() {
        return comorbidity;
    }

    public void setComorbidity(String comorbidity) {
        this.comorbidity = comorbidity;
    }

    public String getComorbidityName() {
        return comorbidityName;
    }

    public void setComorbidityName(String comorbidityName) {
        this.comorbidityName = comorbidityName;
    }
}
