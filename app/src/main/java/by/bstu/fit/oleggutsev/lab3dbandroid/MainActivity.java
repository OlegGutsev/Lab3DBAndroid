package by.bstu.fit.oleggutsev.lab3dbandroid;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;

import static android.os.Environment.getExternalStorageDirectory;

public class MainActivity extends AppCompatActivity {

    private TextView mAbsoluteResult;
    private TextView mNameResult;
    private TextView mPathResult;
    private TextView mReadWriteResult;
    private TextView mExternalStateResult;
    private TextView mExternalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAbsoluteResult = (TextView) findViewById(R.id.AbsoluteResult);
        mNameResult = (TextView) findViewById(R.id.NameResult);
        mPathResult = (TextView) findViewById(R.id.PathResult);
        mReadWriteResult = (TextView) findViewById(R.id.ReadWriteResult);
        mExternalStateResult = (TextView) findViewById(R.id.ExternalStateResult);
        mExternalStateResult.setText(Environment.getExternalStorageState());
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.GetFilesDir:
                WriteToScreen(
                        getFilesDir().getAbsolutePath(),
                        getFilesDir().getName(),
                        getFilesDir().getPath(),
                        getFilesDir().canRead() +
                                "/" + getFilesDir().canWrite()
                );
                break;
            case R.id.GetCacheDir:
                WriteToScreen(
                        getCacheDir().getAbsolutePath(),
                        getCacheDir().getName(),
                        getCacheDir().getPath(),
                        getCacheDir().canRead() +
                                "/" + getCacheDir().canWrite()
                );
                break;
            case R.id.GetExternalFilesDir:
                WriteToScreen(
                        getExternalFilesDir("MyFolder").getAbsolutePath(),
                        getExternalFilesDir("MyFolder").getName(),
                        getExternalFilesDir("MyFolder").getPath(),
                        getExternalFilesDir("MyFolder").canRead() +
                                "/" + getExternalFilesDir("MyFolder").canWrite()
                );
                break;
            case R.id.GetExternalCacheDir:
                WriteToScreen(
                        getExternalCacheDir().getAbsolutePath(),
                        getExternalCacheDir().getName(),
                        getExternalCacheDir().getPath(),
                        getExternalCacheDir().canRead() +
                                "/" + getExternalCacheDir().canWrite()
                );
                break;
            case R.id.GetExternalStorageDirectory:
                WriteToScreen(
                        Environment.getExternalStorageDirectory().getAbsolutePath(),
                        Environment.getExternalStorageDirectory().getName(),
                        Environment.getExternalStorageDirectory().getPath(),
                        Environment.getExternalStorageDirectory().canRead() +
                                "/" + Environment.getExternalStorageDirectory().canWrite()
                );
                break;
            case R.id.GetExternalStoragePublicDirectory:
                WriteToScreen(
                        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath(),
                        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getName(),
                        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getPath(),
                        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).canRead() +
                                "/" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).canWrite()
                );
                break;

        }
    }

    private void WriteToScreen(String absolutePath, String name, String path, String canReadOrWrite) {
        mAbsoluteResult.setText(absolutePath);
        mNameResult.setText(name);
        mPathResult.setText(path);
        mReadWriteResult.setText(canReadOrWrite);
    }
}
