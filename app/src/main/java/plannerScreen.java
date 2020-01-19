import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.example.shakti.studentplanner.CalendarScreen;
import com.example.shakti.studentplanner.SectionsStatePageAdapter;

public class plannerScreen extends CalendarScreen {
    private void setupViewPager(ViewPager viewPager){
        SectionsStatePageAdapter adapter = new SectionsStatePageAdapter(getSupportFragmentManager());
        adapter.addFragment(new plannerScreen(), "planner");

        viewPager.setAdapter(adapter);
    }

    public FragmentManager getSupportFragmentManager() {
        return null;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
