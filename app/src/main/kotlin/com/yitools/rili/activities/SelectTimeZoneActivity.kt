package com.yitools.rili.activities

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import com.yitools.rili.R
import com.yitools.rili.adapters.SelectTimeZoneAdapter
import com.yitools.rili.databinding.ActivitySelectTimeZoneBinding
import com.yitools.rili.helpers.CURRENT_TIME_ZONE
import com.yitools.rili.helpers.TIME_ZONE
import com.yitools.rili.helpers.getAllTimeZones
import com.yitools.rili.models.MyTimeZone
import com.simplemobiletools.commons.extensions.hideKeyboard
import com.simplemobiletools.commons.extensions.viewBinding
import com.simplemobiletools.commons.helpers.NavigationIcon
import java.util.Locale
import java.util.TimeZone

class SelectTimeZoneActivity : SimpleActivity() {
    private var mSearchMenuItem: MenuItem? = null
    private val allTimeZones = getAllTimeZones()

    private val binding by viewBinding(ActivitySelectTimeZoneBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupOptionsMenu()

        SelectTimeZoneAdapter(this, allTimeZones) {
            hideKeyboard()
            val data = Intent()
            data.putExtra(TIME_ZONE, it as MyTimeZone)
            setResult(RESULT_OK, data)
            finish()
        }.apply {
            binding.selectTimeZoneList.adapter = this
        }

        val currentTimeZone = intent.getStringExtra(CURRENT_TIME_ZONE) ?: TimeZone.getDefault().id
        val pos = allTimeZones.indexOfFirst { it.zoneName.equals(currentTimeZone, true) }
        if (pos != -1) {
            binding.selectTimeZoneList.scrollToPosition(pos)
        }
    }

    override fun onResume() {
        super.onResume()
        setupToolbar(binding.selectTimeZoneToolbar, NavigationIcon.Arrow, searchMenuItem = mSearchMenuItem)
    }

    private fun setupOptionsMenu() {
        setupSearch(binding.selectTimeZoneToolbar.menu)
    }

    private fun setupSearch(menu: Menu) {
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        mSearchMenuItem = menu.findItem(R.id.search)
        (mSearchMenuItem!!.actionView as SearchView).apply {
            queryHint = getString(R.string.enter_a_country)
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            isSubmitButtonEnabled = false
            isIconified = false
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String) = false

                override fun onQueryTextChange(newText: String): Boolean {
                    searchQueryChanged(newText)
                    return true
                }
            })
        }

        mSearchMenuItem!!.expandActionView()
        MenuItemCompat.setOnActionExpandListener(mSearchMenuItem, object : MenuItemCompat.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                searchQueryChanged("")
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                hideKeyboard()
                finish()
                return true
            }
        })
    }

    private fun searchQueryChanged(text: String) {
        val timeZones = allTimeZones.filter {
            it.zoneName.lowercase(Locale.getDefault()).contains(text.lowercase(Locale.getDefault()))
        }.toMutableList() as ArrayList<MyTimeZone>
        (binding.selectTimeZoneList.adapter as? SelectTimeZoneAdapter)?.updateTimeZones(timeZones)
    }
}
