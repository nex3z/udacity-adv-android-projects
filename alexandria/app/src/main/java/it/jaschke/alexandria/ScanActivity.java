package it.jaschke.alexandria;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanActivity extends ActionBarActivity implements ZXingScannerView.ResultHandler {
    private static final String LOG_TAG = ScanActivity.class.getSimpleName();

    static final String SCAN_CONTENTS = "scanContents";
    static final String SCAN_FORMAT = "scanFormat";

    private ZXingScannerView mScannerView;

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
    public void handleResult(Result result) {
        Log.v(LOG_TAG, result.getText() + ", " + result.getBarcodeFormat().toString());

        // Toast.makeText(this, result.getText(), Toast.LENGTH_LONG).show();

        Intent returnIntent = new Intent();
        returnIntent.putExtra(SCAN_CONTENTS, result.toString());
        returnIntent.putExtra(SCAN_FORMAT, result.getBarcodeFormat().toString());
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
