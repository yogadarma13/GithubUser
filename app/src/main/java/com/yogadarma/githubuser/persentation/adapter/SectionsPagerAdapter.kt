package com.yogadarma.githubuser.persentation.adapter

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.yogadarma.githubuser.R
import com.yogadarma.githubuser.persentation.fragments.follower.FollowerFragment
import com.yogadarma.githubuser.persentation.fragments.following.FollowingFragment

class SectionsPagerAdapter(private val context: Context, fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var username: String? = null

    @StringRes
    private val TAB_TITLES = intArrayOf(R.string.tab_text_1, R.string.tab_text_2)

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FollowerFragment.newInstance(username)
            1 -> fragment = FollowingFragment.newInstance(username)
        }
        return fragment as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int = 2
}