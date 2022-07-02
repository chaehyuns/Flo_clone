package com.chaehyun.flo_clone

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
//Fragment에 Adapter을 사용해서 전기를 넣어준다고 생각하면 됨.
//adapter는 하나의 class를 상속받아야함 = FragmentStateAdapter
//viewPager에 이미지를 넣어주는데 그냥 이미지를 넣는 것이 아닌 fragment라는 하나의 조각을 만들어서
//fragment안에 이미지 하나를 넣어 여러 fragment를 슬라이드하는 형식으로 전환하기 때문
//class명 빨간 밑줄일때 alt + enter을 누르면 implement members(선언시 꼭 필요한 애들)이 보임 모두 선택하고 만들면됨
class BannerVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    //여러개의 fragment들을 담아둘 공간이 필요하다.
    //하나의 list를 만들어서 여러개의 fragment를 담아둔다.
    //이곳의 class에서만 사용할 것이기 때문에 private이라고 선언하고 초기화한다.(data 변형하지 못하도록 하도록)
    private val fragmentlist : ArrayList<Fragment> = ArrayList()


    override fun getItemCount(): Int {
        //이곳 class에서 연결된 viewPager에게 데이터를 전달할때 data를 몇개를 전달할 것인지를 써주는 함수이다.
        //전달한 list는 fragment list에 담긴 것들의 개수이기 때문에 size
        return fragmentlist.size
        //이런 함수는 간단하게 한줄로 표현하면 아래의 코드로 표현할 수 있다.
        //override fun getItemCount(): Int = fragmentlist.size
    }

    //fragmemnt안에 있는 list들을 생성해주는 함수이다.
    override fun createFragment(position: Int): Fragment = fragmentlist[position]
    //0부터 시작해서 getItemCount된만큼 반환을 해주게 된다.

    //이 함수가 실행될때 fragmentlist에는 아무런 데이터가 없으므로 homeFragment에서 추가해줄 fragment를 써주기 위한 함수이다.
    fun addFragment(fragment: Fragment) {
        //fragment의 인자값으로 받은 feagment를 추가해 줄거라는 코드
        fragmentlist.add(fragment)
        //list안에 새로운 값이 추가가 되어줬을때viewpager에게 새로운 값이 추가가 됐다는 것을 알려주기 위한 코드
        //fragmentlist.size-1는 새로운 값이 list에 추가되는 곳을 말하는 것이다.
        //처음에 list에 값이 들어오면 index 0번째에 값이 들어가게 되고 size는 1이 되기 때문에 -1
        notifyItemInserted(fragmentlist.size-1)
    }

}