package sc13014.fia.ues.sv.basedatossc13014;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NotaConsultarActivity extends Activity {

    ControlBDSC13014 helper;
    EditText editCarnet;
    EditText editCodmateria;
    EditText editCiclo;
    EditText editNotafinal;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_consultar);
        helper = new ControlBDSC13014(this);
        editCarnet = (EditText) findViewById(R.id.editCarnet);
        editCodmateria = (EditText) findViewById(R.id.editCodmateria);
        editCiclo = (EditText) findViewById(R.id.editCiclo);
        editNotafinal = (EditText) findViewById(R.id.editNotafinal);
    }

    public void consultarNota(View v) {
        helper.abrir();
        Nota nota = helper.consultarNota( editCarnet.getText().toString(),
                editCodmateria.getText().toString(), editCiclo.getText().toString());
        helper.cerrar();
        if(nota == null)
            Toast. makeText(this, "Nota no registrada", Toast.LENGTH_LONG).show();
        else{
            editNotafinal.setText(String. valueOf(nota.getNotafinal()));
        }
    }

    public void limpiarTexto(View v) {
        editCarnet.setText("");
        editCodmateria.setText( "");
        editCiclo.setText( "");
        editNotafinal.setText("");
    }
}