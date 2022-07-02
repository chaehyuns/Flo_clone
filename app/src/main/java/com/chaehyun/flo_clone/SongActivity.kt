package com.chaehyun.flo_clone

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.chaehyun.flo_clone.databinding.ActivityMainBinding
import com.chaehyun.flo_clone.databinding.ActivitySongBinding

//***액티비티가 추가될 때에는 항상 manifest파일에 activity를 추가해야 앱이 튕기지 않는다.***

//appCompatActivity()는 안드로이드에서 엑티비티를 사용할 수 있게 해주는 클래스 (소괄호 필요)
class SongActivity : AppCompatActivity() {
    //viewbinding을 사용(graddle파일에 추가)

    //전역변수 선언(나중에 초기화를 해주는)
    //activity_song.xml파일을 연결
    lateinit var binding : ActivitySongBinding

    //액치비티가 생성될때 무조건 생성되어야하는 onCreate함수를 선언한다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding을 초기화 시켜줌
        //inflater는 xml에 표기된 메모리?를 객체화 시키는 아이(하나의 패턴임을 외워라ㅏ,,,)
        binding = ActivitySongBinding.inflate(layoutInflater)
        //xml에 있는 것을 마음껏 쓰게 할거라는 의미의 setContentView를 사용한다.
        //root가 무엇인지 궁금하다면 ctrl+클릭하면 최상단의 레이아웃이 나옴.
        setContentView(binding.root)

        //downid를 클릭하면 송액티비티를 종료하는 binding (finish매소드를 사용)
        binding.songDownIb.setOnClickListener {
            finish()
        }

        //플레이버튼을 클릭하면 정지버튼이 나오도록(반대도 마찬가지)
        binding.songMiniplayerIv.setOnClickListener(){
            setPlayerStatus(false)
        }
        binding.songPauseIv.setOnClickListener {
            setPlayerStatus(true)
        }
    }

    //클릭 됐을 때를 알 수 있는 fun
    fun setPlayerStatus(isPlaying : Boolean) {
        if(isPlaying) {
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
        }
        else {
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
        }
    }

    //homeFragment에서 선택된 제목과 가수명을 songActivity로 받아옴
    //data를 담아두는 dataclass에 대한 이해가 필요
    //if문을 사용하여서 data가 들어있는지 안들어있는지 파악을 하고 그 뒤에 처리
    /*
    if (intent.hasExtra("title") && intent.hasExtra("singer")) {
        binding.songMusicTitleTv.text = intent.getStringExtra("title")
        binding.songSingerNameTv.text -= intent.getStringExtra("singer")
    }
     */

}