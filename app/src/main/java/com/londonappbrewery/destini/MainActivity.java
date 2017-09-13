package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.R.attr.button;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyTextView;
    Button buttonTop;
    Button buttonBottom;
    int mIndex = 0;
    int storyLine;
    int btnTop;
    int btnBottom;

    private Answer[] story = new Answer[]{
            new Answer(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2), //0
            new Answer(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),//1
            new Answer(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),//2
            new Answer(R.string.T4_End),//3
            new Answer(R.string.T5_End),//4
            new Answer(R.string.T6_End)//5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storyTextView = (TextView) findViewById(R.id.storyTextView);
        buttonTop = (Button) findViewById(R.id.buttonTop);
        buttonBottom = (Button) findViewById(R.id.buttonBottom);


        buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upateStory(mIndex, true);
            }
        });
        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upateStory(mIndex, false);
            }
        });
    }

    private void upateStory(int mIndex, boolean bool){

        if(mIndex == 0 && bool == true){
            mIndex += 2;//T3
            this.mIndex = mIndex;
            storyLine = story[mIndex].getText();
            btnTop = story[mIndex].getButtonTop();
            btnBottom = story[mIndex].getButtonBottom();
            storyTextView.setText(storyLine);
            buttonTop.setText(btnTop);
            buttonBottom.setText(btnBottom);
            //Index == 2
        }else if (mIndex == 0 && bool == false){
            mIndex += 1;//T2
            this.mIndex = mIndex;
            storyLine = story[mIndex].getText();
            btnTop = story[mIndex].getButtonTop();
            btnBottom = story[mIndex].getButtonBottom();
            storyTextView.setText(storyLine);
            buttonTop.setText(btnTop);
            buttonBottom.setText(btnBottom);
        } else if(mIndex == 1 && bool == false){
            mIndex += 2;//T4
            this.mIndex = mIndex;
            storyLine = story[mIndex].getText();
            btnTop = story[mIndex].getButtonTop();
            btnBottom = story[mIndex].getButtonBottom();
            storyTextView.setText(storyLine);
            buttonTop.setVisibility(LinearLayout.GONE);
            buttonBottom.setVisibility(LinearLayout.GONE);
        }
        else if(mIndex == 1 && bool == true){
            mIndex += 1;//T3
            this.mIndex = mIndex;
            storyLine = story[mIndex].getText();
            btnTop = story[mIndex].getButtonTop();
            btnBottom = story[mIndex].getButtonBottom();
            storyTextView.setText(storyLine);
            buttonTop.setText(btnTop);
            buttonBottom.setText(btnBottom);
        }
        else if (mIndex == 2 && bool == true){
            mIndex += 3; //T6
            this.mIndex = mIndex;
            storyLine = story[mIndex].getText();
            btnTop = story[mIndex].getButtonTop();
            btnBottom = story[mIndex].getButtonBottom();
            storyTextView.setText(storyLine);
            buttonTop.setVisibility(LinearLayout.GONE);
            buttonBottom.setVisibility(LinearLayout.GONE);
        } else if (mIndex == 2 && bool == false){
            mIndex += 2; //T5
            this.mIndex = mIndex;
            storyLine = story[mIndex].getText();
            btnTop = story[mIndex].getButtonTop();
            btnBottom = story[mIndex].getButtonBottom();
            storyTextView.setText(storyLine);
            buttonTop.setVisibility(LinearLayout.GONE);
            buttonBottom.setVisibility(LinearLayout.GONE);
        }
    }
}
