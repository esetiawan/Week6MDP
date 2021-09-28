package id.ac.week6mdp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MahasiswaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Mahasiswa> mhsarr;

    public MahasiswaAdapter(Context context) {
        this.context = context;
        this.mhsarr = new ArrayList<>();
    }

    public void setMhsarr(ArrayList<Mahasiswa> mhsarr) {
        this.mhsarr = mhsarr;
    }

    @Override
    public int getCount() { //berapa data dari arraylist yg akan ditampilkan
        return mhsarr.size(); //semua data
    }

    @Override
    public Object getItem(int position) {
        return mhsarr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_mhs,parent,
                    false);
        }
        ViewHolder vh = new ViewHolder(convertView);
        vh.bind((Mahasiswa) getItem(position));
        return convertView;
    }
    private class ViewHolder{ //inner class
        private TextView tvnrp,tvnama,tvmajor;
        ViewHolder(View v) //menghubungkan ViewHolder dengan widget di item_mhs.xml
        {
            tvnrp = v.findViewById(R.id.textView_nrp);
            tvnama = v.findViewById(R.id.textView_name);
            tvmajor = v.findViewById(R.id.textView_major);
        }
        void bind(Mahasiswa mhs) { //mengisi UI dengan data
            tvnrp.setText(mhs.getNrp());
            tvnama.setText(mhs.getNama());
            tvmajor.setText(mhs.getMajor());
        }
    }
}
