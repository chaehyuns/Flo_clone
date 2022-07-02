package com.chaehyun.flo_clone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chaehyun.flo_clone.databinding.FragmentBannerBinding

//(var imaRes : Int)을 사용해 새로운 viewPager가 입력될때마다 여러개의 이미지를 넣을 수 있게 함.
class BannerFragment(var imaRes : Int) : Fragment(){
    //binding을 사용하기 위한 선언
    lateinit var binding : FragmentBannerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBannerBinding.inflate(inflater, container, false)
        //imgRes를 추가하는 것은 bannerFragment에 있는 내용을 binding으로 불러온다.
        binding.bannerImageIv.setImageResource(imaRes)


        return binding.root
    }
}