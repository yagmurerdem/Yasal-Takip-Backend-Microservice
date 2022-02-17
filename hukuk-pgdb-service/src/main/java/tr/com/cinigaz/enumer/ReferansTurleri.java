package tr.com.cinigaz.enumer;

public enum ReferansTurleri {
    TESISAT ("Tesisat"),
    SOZLESME ("Sözleşme"),
    MUHATAP ("Muhatap"),
    TCKIMLIK ("T.C. Kimlik"),
    DIGER ("Diğer");

    private String referansString;
    ReferansTurleri(String referansString) {
        this.referansString = referansString;
    }
    public String getReferansString() {
        return referansString;
    }
}
