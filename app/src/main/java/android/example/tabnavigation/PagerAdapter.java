package android.example.tabnavigation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**mendeklarasikan jumlah tab ada berapa menggunakan page adapter**/

public class PagerAdapter extends FragmentStatePagerAdapter {

    int numOfTabs;
    public PagerAdapter(@NonNull FragmentManager fm, int tabCount) {
        super(fm);
        this.numOfTabs=numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        /**mengatur posisi fragment saat user memilih**/
        /**misal mau pilih pertama berarti menggunakan first fragment**/
        switch (position){
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            default:
                return null;

        }
    }

    /**mengatur jumlah tabs**/
    @Override
    public int getCount() {

        return numOfTabs;
    }
}
