package com.bangkit.faniabdullah_made.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bangkit.faniabdullah_made.favorite.ui.FavoriteMovieFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    @StringRes
    private val tabTitles = intArrayOf(
        R.string.movie_title_fav,
        R.string.tvShows_title_fav
    )

    private val fragment: List<Fragment> = listOf(
        FavoriteMovieFragment(isMovie = true),
        FavoriteMovieFragment(isMovie = false),
    )

    override fun getPageTitle(position: Int): CharSequence {
        return mContext.getString(tabTitles[position])
    }

    override fun getCount() = tabTitles.size

    override fun getItem(position: Int): Fragment {
        return fragment[position]
    }
}