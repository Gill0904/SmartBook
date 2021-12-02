package com.example.smartbook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;

import static android.content.ContentValues.TAG;

public class Visualizador extends AppCompatActivity implements OnPageChangeListener,
        OnPageErrorListener {

    PDFView pdfView;
    Integer pageNumber = 0;
    String pdfFileName=MainActivity.libro;
    public String FILE = (MainActivity.libro.replace(" ",""))+".pdf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizador);
        pdfView=findViewById(R.id.pdfViewer);
        displayFromAsset(pdfFileName);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbarRegistro);

        setSupportActionBar(toolbar);

        ActionBar actionBar = ((AppCompatActivity) this).getSupportActionBar();
        if(actionBar!=null){
            actionBar.setTitle(MainActivity.libro);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        }
    }

    private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;

        pdfView.fromAsset(FILE)
                .defaultPage(pageNumber)
                .onPageChange(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(10) // in dp
                .onPageError(this)
                .pageFitPolicy(FitPolicy.BOTH)
                .load();
    }
    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pageCount));
    }
    @Override
    public void onPageError(int page, Throwable t) {
        Log.e(TAG, "Cannot load page " + page);
    }
}