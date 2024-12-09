package entities;

public class Passenger {
    private String nama;
    private String umur;
    private String jenisKelamin;
    private String tanggalLahir;
    private String nomorPaspor;
    private String nomorKTP;

    public Passenger(String nama, String umur, String jenisKelamin, String tanggalLahir, String nomorPaspor, String nomorKTP) {
        this.nama = nama;
        this.umur = umur;
        this.jenisKelamin = jenisKelamin;
        this.tanggalLahir = tanggalLahir;
        this.nomorPaspor = nomorPaspor;
        this.nomorKTP = nomorKTP;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getNomorPaspor() {
        return nomorPaspor;
    }

    public void setNomorPaspor(String nomorPaspor) {
        this.nomorPaspor = nomorPaspor;
    }

    public String getNomorKTP() {
        return nomorKTP;
    }

    public void setNomorKTP(String nomorKTP) {
        this.nomorKTP = nomorKTP;
    }
}
