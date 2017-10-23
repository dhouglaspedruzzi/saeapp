package com.app.sae.sae;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;

import org.json.JSONException;
import org.json.JSONObject;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    public static String ESPACO_ID = "espaco_id";
    public static String DESCRICAO_ESPACO = "descricao_espaco";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        mScannerView.resumeCameraPreview(this);
        exibirHorarios(rawResult.getText());
    }

    private void exibirHorarios(String jsonString) {
        try {
            JSONObject json= new JSONObject(jsonString);

            if (json.has("id") && json.has("descricao")) {
                Intent intent = new Intent(this, HorarioActivity.class);
                intent.putExtra(ESPACO_ID, json.getString("id"));
                intent.putExtra(DESCRICAO_ESPACO, json.getString("descricao"));
                startActivity(intent);
            } else {
                Toast.makeText(this, "QrCode Inválido", Toast.LENGTH_LONG).show();
            }
        } catch (JSONException e) {
            Toast.makeText(this, "QrCode Inválido", Toast.LENGTH_LONG).show();
        }
    }
}
