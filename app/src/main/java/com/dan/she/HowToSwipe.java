package com.dan.she;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class HowToSwipe extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_how_to_swipe);

        addFragment(new Step.Builder()
        .setTitle("About S.H.E.")
        .setContent("In order to ask for help, you need to add your family and friends mobile number.").setSummary("Step 1")
        .setBackgroundColor(Color.parseColor("#2E77BC"))
        .setDrawable(R.drawable.asfase).build());

        addFragment(new Step.Builder()
                .setTitle("How to use in trouble?")
                .setContent("Just press the volume up/down button for 5 seconds.")
                .setSummary("Step 2")
                .setBackgroundColor(Color.parseColor("#2E77BC"))
                .setDrawable(R.drawable.abcd).build());

        addFragment(new Step.Builder()
                .setTitle("\nSAFETY INSTRUCTIONS\n")
                .setContent("1. Have a Plan\n" +
                        "\n"+"When you are going out, whether it be alone or with a group of friends, it is best to have a plan in place.\n"
                        +"\n" + "2. Ping Your Location\n"+"\n"+"Smartphones are not only a great tool for taking photos, sending messages, and sharing news, but they can also be lifesavers.\n"
                        +"\n" + "3. Tools for Self-Defense\n" +"\n"+"Items such as pepper spray, a safety whistle, and a mini flashlight, are great options to have on hand when going out. \n"
                        +"\n" + "4. Create Boundaries\n"+"\n"+"Regardless if you are out alone or with a group of friends, if you ever feel uncomfortable or unsafe with someone’s attention toward you, do not be afraid to put distance between yourself and the individual. \n"
                        +"\n" + "5. Power Up\n"+"\n"+"Turn safety into fun and try a class in self-defense! We never want to think the worst could happen.  \n")
//                .setSummary("Step 3")
//                .setSummary("This is summary")
                .setBackgroundColor(Color.parseColor("#2E77BC")).build());
//                .setDrawable(R.drawable.s3).
    }


    @Override
    public void currentFragmentPosition(int position) {

    }
}
