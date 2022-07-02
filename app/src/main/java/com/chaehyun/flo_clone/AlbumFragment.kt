package com.chaehyun.flo_clone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chaehyun.flo_clone.databinding.FragmentAlbumBinding
import com.chaehyun.flo_clone.databinding.FragmentHomeBinding

//Fragment 전환
//Fragment를 상속받는다
class AlbumFragment : Fragment() {
    lateinit var binding: FragmentAlbumBinding

    //fragment는 oncreate가 아닌 oncreateView를 사용한다.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //fragment에서 binding을 추가하는 방법
        binding = FragmentAlbumBinding.inflate(inflater, container, false)

        binding.albumBackIv.setOnClickListener {
            //homefragment안의 하나의 조각임
            //fragment의 조각을 어디로 이동하는지를 말하는 거라고 생각하는 게 좋음
            //mainActivity의 main_frm
            //commitAllowingStateLoss()는 내부적으로 작동하는 기능임(하나의 패턴이라고 생각하는것이 좋음)
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm,AlbumFragment()).commitAllowingStateLoss()
        }
        return binding.root
    }
}