package id.ac.week6mdp;

import android.os.Parcel;
import android.os.Parcelable;

public class Mahasiswa implements Parcelable {
    private String Nrp, Nama, Major;

    public Mahasiswa(String nrp, String nama, String major) {
        Nrp = nrp;
        Nama = nama;
        Major = major;
    }

    protected Mahasiswa(Parcel in) {
        Nrp = in.readString();
        Nama = in.readString();
        Major = in.readString();
    }

    public static final Creator<Mahasiswa> CREATOR = new Creator<Mahasiswa>() {
        @Override
        public Mahasiswa createFromParcel(Parcel in) {
            return new Mahasiswa(in);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };

    public String getNrp() {
        return Nrp;
    }

    public void setNrp(String nrp) {
        Nrp = nrp;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Nrp);
        dest.writeString(Nama);
        dest.writeString(Major);
    }

    @Override
    public String toString() {
        return "Mahasiswa dengan data" +
                "Nrp='" + Nrp + '\'' +
                ", Nama='" + Nama + '\'' +
                ", Major='" + Major + '\'';
    }
}
