package com.aaks32173.sih2022new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class yoga extends AppCompatActivity {
    String videoUrl9=null;
    String videoUrl8=null;
    String videoUrl6=null;
    String videoUrl7=null;
    String videoUrl5=null;
    String videoUrl4=null;
    String videoUrl3=null;
    String videoUrl = null;
    String videoUrl2=null;
      @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_yoga);

          String category = getIntent().getExtras().getString("category");

          Toast.makeText(this, category, Toast.LENGTH_SHORT).show();
            int age=5;

          if(age>8){

                 videoUrl9="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/exercises%2Fyogas%2Fanxiety_release_yoga5.mp4?alt=media&token=ff509dbb-24f9-4d8c-921c-fd16e687cf2e";
                 videoUrl8="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/exercises%2Fyogas%2Fanxiety_release_yoga4.mp4?alt=media&token=d04e8c49-885a-4713-9d87-5406eae0d5cc";
                 videoUrl6 ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/exercises%2Fyogas%2Fanxiety_release_yoga2.mp4?alt=media&token=479e5819-5e8d-45ac-bc57-ef7c812a5d32";
                 videoUrl7="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/exercises%2Fyogas%2Fanxiety_release_yoga3.mp4?alt=media&token=1dcf914f-c059-4f30-ad98-f4ff2f1d24a0";
                 videoUrl5 = "https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/exercises%2Fyogas%2Fanxiety_release_yoga.mp4?alt=media&token=7ac66073-e040-4268-8385-3df8acc266b5";
                 videoUrl4 ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/exercises%2Fyogas%2Fneck_streching_yoga.mp4?alt=media&token=4834a212-a6e8-47f1-979b-bda7fc5bf124";
                 videoUrl3 ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/exercises%2Fyogas%2Ffocus_build_yoga.mp4?alt=media&token=ac306705-5d17-419b-b010-c4f001603aae";
                 videoUrl = "https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/exercises%2Fyogas%2Fconcentration_build_yoga1.mp4?alt=media&token=7208a3c5-5d4c-4a79-82e0-cca9cd53e1a9";
                videoUrl2 = "https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/exercises%2Fyogas%2Fconcentration_build_yoga2.mp4?alt=media&token=0abd607f-9ff1-43df-a3ae-cea3d2b7d446";

            }
          else if(category=="gksection"){

              videoUrl9="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2FG.K%2Fquiz1.mp4?alt=media&token=2a3e42b5-8d3b-4c2b-8de6-6b2c34750c1f";
              videoUrl8="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2FG.K%2Fquiz2.mp4?alt=media&token=e6c25d0f-3c6e-48ca-be0b-5c0597a99d74";
              videoUrl6 ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2FG.K%2Fquiz3.mp4?alt=media&token=5ddd34ed-a5f4-4fa0-b9ce-dc434f68337a";
              videoUrl7="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2FG.K%2Fquiz4.mp4?alt=media&token=16aaea66-a049-4867-8f8a-0de8251cae14";
              videoUrl5 ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2FG.K%2Fvideoplayback%20(1).mp4?alt=media&token=0aebfebc-cba0-4cbb-9b26-88bdcb99f160";
              videoUrl4 ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2FG.K%2Fvideoplayback%20(2).mp4?alt=media&token=faafabcd-2e68-46d3-b129-f266e8895443";
              videoUrl3 ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2FG.K%2Fvideoplayback.mp4?alt=media&token=cd9302c6-896f-45b9-bb74-72e3fb3b90b9";
              videoUrl ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2FG.K%2Fvideoplayback.mp4?alt=media&token=cd9302c6-896f-45b9-bb74-72e3fb3b90b9";
              videoUrl2 ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2FG.K%2Fvideoplayback.mp4?alt=media&token=cd9302c6-896f-45b9-bb74-72e3fb3b90b9";

          }
          else if(category=="fightyourfear"){

               videoUrl9="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2FFight_your_fear%2F100%20Kids%20Tell%20Us%20Their%20Fears%20%F0%9F%91%B9%F0%9F%8E%83%F0%9F%91%BB%20_%20100%20Kids%20_%20HiHo%20Kids.mp4?alt=media&token=05d8" +
                      "1a20-a16b-44eb-8c50-46ed6044c298";
               videoUrl8="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2FFight_your_fear%2FFight%20Your%20Fears%20to%20Be%20Victorious%20_%20Coward%20Pompu%20Story%20_%20Moral%20Stories%20By%20Granny%20_%20Woka%20English.mp4?a" +
                      "lt=media&token=20ce7cee-3f0c-4c2a-9a86-bc8d952cd767";
               videoUrl6 ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2FFight_your_fear%2FFinding%20Your%20Voice%20From%20a%20Kid%20Who%20Had%20Stage%20Fright%20_%20Eamonn%20Kennedy%20_%20TEDxStJosephsSchoolYorkville.mp4?" +
                      "alt=media&token=0fe6cf6b-a684-4934-bb30-c7523adaf08e";
              videoUrl7="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2FFight_your_fear%2FProven%20Strategies%20to%20Help%20Children%20Overcome%20Fears%20_%20Age-Related%20Fears%20_%20Why%20is%20my%20Child%20Afraid_.mp4?alt=media&token=3f52b" +
                      "d34-b57e-41a9-a797-132331363b13";
               videoUrl5 = "https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2FFight_your_fear%2FSmall%20Talk%20_%20Fears%20_%20CBC%20Kids.mp4?alt=media&token=ae6555ec-3bfe-" +
                      "4a8a-9ddb-4f215b3964d9";
               videoUrl4 ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2FFight_your_fear%2Fvideoplayback%20(1).mp4?alt=media&token=c71" +
                      "28b63-618e-45de-95f4-e35d43a07511";
               videoUrl3 ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2FFight_your_fear%2Fvideoplayback%20(1).mp4?alt=media&token=c" +
                      "7128b63-618e-45de-95f4-e35d43a07511";
               videoUrl = "https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2FFight_your_fear%2Fvideoplayback%20(2).mp4?alt=media&token=cea6a8c5-b4a1-4792-9728-1440" +
                      "545d081f";
               videoUrl2 = "https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2FFight_your_fear%2Fvideoplayback%20(2).mp4?alt=media&token=cea6a8c5-b4a1-" +
                      "4792-9728-1440545d081f";
          }
          else if(category=="wetime"){

              videoUrl9="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2Fpodcast%2Fvideoplayback%20(1).mp4?alt=media&token=03fb5dee-5dd1-4636-95ab-e0e600140ce5";
              videoUrl8="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2Fpodcast%2Fvideoplayback%20(2).mp4?alt=media&token=94fb88f1-ddcc-46c2-9ec1-281a7d8bfbd8";
              videoUrl6 ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2Fpodcast%2Fvideoplayback%20(3).mp4?alt=media&token=f08c7496-28a8-4870-b223-76569da775e4";
              videoUrl7="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2Fpodcast%2Fvideoplayback%20(4).mp4?alt=media&token=570aae37-61c2-40c0-a554-c72b92e77597";
              videoUrl5 ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2Fpodcast%2Fvideoplayback%20(5).mp4?alt=media&token=bfefd090-ca92-40a4-bb4b-0fc23710c5fa";
              videoUrl4 ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2Fpodcast%2Fvideoplayback%20(6).mp4?alt=media&token=330db1b2-01ad-4590-b609-76b40869c062";
              videoUrl3 ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2Fpodcast%2Fvideoplayback%20(7).mp4?alt=media&token=308e8eb6-6bf8-46db-9a69-357b42bc4305";
              videoUrl ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2Fpodcast%2Fvideoplayback%20(6).mp4?alt=media&token=330db1b2-01ad-4590-b609-76b40869c062";
              videoUrl2 ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2Fpodcast%2Fvideoplayback%20(7).mp4?alt=media&token=308e8eb6-6bf8-46db-9a69-357b42bc4305";

          }
         else{
              videoUrl9="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2Frhymes%2Fvideoplayback%20(1).mp4?alt=media&token=f4681b94-8e25-493f-903e-db18bc31f0ba";
              videoUrl8="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2Frhymes%2Fvideoplayback%20(2).mp4?alt=media&token=2129d043-103a-4204-8b01-d3cdbb0d9936";
              videoUrl6 ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/exercises%2Fyogas%2Fanxiety_release_yoga2.mp4?alt=media&token=479e5819-5e8d-45ac-bc57-ef7c812a5d32";
              videoUrl7="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2Frhymes%2Fvideoplayback%20(3).mp4?alt=media&token=44236090-a52c-4cd2-9214-9d53a6053e39";
              videoUrl5 = "https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2Frhymes%2Fvideoplayback%20(5).mp4?alt=media&token=94c40c63-122c-4ced-882c-27c76f16e310";
              videoUrl4 ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2Frhymes%2Fvideoplayback%20(6).mp4?alt=media&token=ce3fbaa0-0a2a-49f2-8f7f-9afd9edb15f1";
              videoUrl3 ="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2Frhymes%2Fvideoplayback%20(7).mp4?alt=media&token=f1b9bb6e-4d24-43ec-b232-c032f5146e0f";
              videoUrl = "https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2Frhymes%2Fvideoplayback%20(8).mp4?alt=media&token=37fbb7e8-0f98-4c15-a7bc-576206775fb6";
              videoUrl2 = "https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/kids%2Frhymes%2Fvideoplayback.mp4?alt=media&token=11b9d95e-0648-4ecb-866f-bea3d43b6117";

          }

            Button btn1 = findViewById(R.id.btn1);
            Button btn2 = findViewById(R.id.btn2);
            Button btn3 = findViewById(R.id.btn3);
            Button btn4 = findViewById(R.id.btn4);
            Button btn5 = findViewById(R.id.btn5);
            Button btn6 = findViewById(R.id.btn6);
            Button btn7 = findViewById(R.id.btn7);
            Button btn8 = findViewById(R.id.btn8);
            Button btn9 = findViewById(R.id.btn9);
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vedioPlayer(videoUrl);
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vedioPlayer(videoUrl2);
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vedioPlayer(videoUrl3);
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vedioPlayer(videoUrl4);
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vedioPlayer(videoUrl5);
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vedioPlayer(videoUrl6);
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vedioPlayer(videoUrl7);
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vedioPlayer(videoUrl8);
                }
            });
            btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vedioPlayer(videoUrl9);
                }
            });
        }
        private void vedioPlayer(String url){
            Intent intent = new Intent(this,vedioPlay.class);
            intent.putExtra("url", url);
            intent.putExtra("nxt", "yoga");
            startActivity(intent);

        }
}