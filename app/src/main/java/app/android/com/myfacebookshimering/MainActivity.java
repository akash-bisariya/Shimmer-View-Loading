package app.android.com.myfacebookshimering;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.tv_hello)
    TextView tvHello;
    @BindView(R.id.tv_hello_2)
    TextView tvHello2;
    @BindView(R.id.shimmer_view)
    ShimmerFrameLayout shimmerView;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            if (message.what == 101) {
                tvHello.setText("Loading task completed..");
                tvHello2.setText("Loading task completed..");
                ivImage.setImageResource(R.drawable.ic_launcher_background);
                shimmerView.stopShimmerAnimation();
                reset();
            }
            return false;
        }
    });


    /**
     * Resetting to default values
     */
    private void reset()
    {
        tvHello.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        tvHello2.setBackgroundColor(getResources().getColor(android.R.color.transparent));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        shimmerView.startShimmerAnimation();
        mHandler.sendEmptyMessageDelayed(101, 5000);


    }
}
