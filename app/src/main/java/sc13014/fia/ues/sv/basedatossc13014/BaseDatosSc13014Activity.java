package sc13014.fia.ues.sv.basedatossc13014;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BaseDatosSc13014Activity extends ListActivity {

    String[] menu={"Tabla Alumno" , "Tabla Nota" , "Tabla Materia" , "LLenar Base de Datos" };
    String[] activities={"AlumnoMenuActivity" , "NotaMenuActivity" , "MateriaMenuActivity" };
    ControlBDSC13014 BDhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter( new ArrayAdapter<String>(this ,android.R.layout.simple_list_item_1, menu));
        BDhelper = new ControlBDSC13014(this);
    }

    @Override
    protected void onListItemClick(ListView l,View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        if(position!=3){
            String nombreValue=activities[position];
            try{
                Class<?> clase=Class. forName("sc13014.fia.ues.sv.basedatossc13014."+nombreValue);
                Intent inte = new Intent(this,clase);
                this.startActivity(inte);
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{
            BDhelper.abrir();
            String tost = BDhelper.llenarBDCarnet();
            BDhelper.cerrar();
            Toast.makeText(this, tost, Toast.LENGTH_SHORT).show();
        }
    }
}
