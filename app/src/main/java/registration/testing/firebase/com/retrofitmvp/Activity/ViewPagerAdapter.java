package registration.testing.firebase.com.retrofitmvp.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private int noOfItems;
    int noOfItemss;

    public ViewPagerAdapter(FragmentManager fm, int noOfItems) {
        super(fm);
        this.noOfItemss = noOfItems;
    }

    @Override
    public Fragment getItem(int position) {
        return OneFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return noOfItems;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "TAB "+(position+1);
    }
}