 package com.androidsfuture.museumsboston;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MapsFree<PointLocation> extends MapActivity {
    /** Called when the activity is first created. */
	List<Overlay> mapOverlays;
	Drawable drawable;
	MuseumItemizedOverlay itemizedOverlay;
	Context mContext;
	MapView mapView;
	MyLocationOverlay me=null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps);

        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        
        mapOverlays = mapView.getOverlays();
        drawable = this.getResources().getDrawable(R.drawable.museum_48);
        itemizedOverlay = new MuseumItemizedOverlay(drawable);
        
        me=new MyLocationOverlay(this, mapView);
        
        me.runOnFirstFix(new Runnable() { public void run() {
            mapView.getController().animateTo(me.getMyLocation());
        }});
        
    	mapView.getOverlays().add(me);
              
        GeoPoint point07 = new GeoPoint((int) (42.350742*1E6), (int) (-71.048842*1E6));
        OverlayItem overlayitem07 = new OverlayItem(point07, 
        		"Boston Fire Museum", "344 Congress Street, Boston, MA  02210");
        
        GeoPoint point08 = new GeoPoint((int) (42.33038*1E6), (int) (-71.166187*1E6));
        OverlayItem overlayitem08 = new OverlayItem(point08, 
        		"Boston College McMullen Museum of Art", "140 Commonwealth Avenue, Devlin Hall 108, Chestnut Hill, MA 02467");
        
        
        GeoPoint point43 = new GeoPoint((int) (42.436*1E6), (int) (-71.214709*1E6));
        OverlayItem overlayitem43 = new OverlayItem(point43, 
        		"National Heritage Museum", "33 Marrett Road, Lexington, MA 02421");
        
        GeoPoint point44 = new GeoPoint((int) (42.468515*1E6), (int) (-71.349334*1E6));
        OverlayItem overlayitem44 = new OverlayItem(point44, 
        		"The Old Manse", "269 Monument Street, Concord, MA");
        
        GeoPoint point51 = new GeoPoint((int) (42.292543*1E6), (int) (-71.307008*1E6));
        OverlayItem overlayitem51 = new OverlayItem(point51, 
        		"Davis Museum & Cultural Center", "106 Central Street, Wellesley, MA 02481-8203");
        
        
        
        itemizedOverlay.addOverlay(overlayitem07);
        itemizedOverlay.addOverlay(overlayitem08);
        itemizedOverlay.addOverlay(overlayitem43);
        itemizedOverlay.addOverlay(overlayitem44);
        itemizedOverlay.addOverlay(overlayitem51);
        
        
        mapOverlays.add(itemizedOverlay);
        
		MapController mapControl = mapView.getController();
        mapControl.setCenter(itemizedOverlay.getCenter());
        mapControl.zoomToSpan(itemizedOverlay.getLatSpanE6(), itemizedOverlay.getLonSpanE6());
    }
    
    @Override
	public void onResume() {
		super.onResume();
		me.enableMyLocation();
		me.enableCompass();
	}		

	@Override
	public void onPause() {
		super.onPause();
		me.disableMyLocation();
		me.disableCompass();
	}
    

    protected boolean isRouteDisplayed() {
        return false;
    }
	    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.map_menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        
        case R.id.Sat_View:
        	mapView.setSatellite(true);
            mapView.setStreetView(true);
            return true;
            
        case R.id.Map_View:
        	mapView.setSatellite(false);
            mapView.setStreetView(false);
            return true;
        
        case R.id.Map_Menu_All:
        	
    		startActivity(new Intent(this, Maps.class));
    		Toast.makeText(this, R.string.toast_all, Toast.LENGTH_LONG).show();
    		this.finish();
    		return true;
    		
    	case R.id.Map_Menu_Free:
    		
    		startActivity(new Intent(this, MapsFree.class));
    		Toast.makeText(this, R.string.toast_free, Toast.LENGTH_LONG).show();
    		this.finish();
    		return true;
    		
    	case R.id.Map_Menu_Art:
    		
    		startActivity(new Intent(this, MapsArt.class));
    		Toast.makeText(this, R.string.toast_art, Toast.LENGTH_LONG).show();
    		this.finish();
    		return true;
    		
    	case R.id.Map_Menu_Mansion:
    		
    		startActivity(new Intent(this, MapsMansion.class));
    		Toast.makeText(this, R.string.toast_mansion, Toast.LENGTH_LONG).show();
    		this.finish();
    		return true;
    		
    	case R.id.Map_Menu_History:
    	
    		startActivity(new Intent(this, MapsHistory.class));
    		Toast.makeText(this, R.string.toast_history, Toast.LENGTH_LONG).show();
    		this.finish();
    		return true;
    		
    	case R.id.Map_Menu_Science:
    	
    		startActivity(new Intent(this, MapsScience.class));
    		Toast.makeText(this, R.string.toast_science, Toast.LENGTH_LONG).show();
    		this.finish();
    		return true;
    		
        default:
            return super.onOptionsItemSelected(item);
        }
    }   
	    
	    
	    
    public class MuseumItemizedOverlay extends ItemizedOverlay {

    	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
    	
    	public MuseumItemizedOverlay(Drawable defaultMarker) {
    		super(boundCenterBottom(defaultMarker));
    		
    		// TODO Auto-generated constructor stub
    	}
    	
    	public void addOverlay(OverlayItem overlay) {
    	    mOverlays.add(overlay);
    	    populate();
    	}

    	@Override
    	protected OverlayItem createItem(int i) {
    		// TODO Auto-generated method stub
    		return mOverlays.get(i);
    	}

    	@Override
    	public int size() {
    		// TODO Auto-generated method stub
    		return mOverlays.size();
    	}
    	
    	@Override
    	protected boolean onTap(int index) {
    	
    	
    	  final OverlayItem item = mOverlays.get(index);
    	  AlertDialog.Builder dialog = new AlertDialog.Builder(MapsFree.this);
    	  dialog.setTitle(item.getTitle());
    	  dialog.setMessage(item.getSnippet());
    	  
    	  dialog.setNegativeButton("Navigate", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int id) {
				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://maps.google.com/maps?daddr=" + item.getSnippet())));
				
			}
		});
    	  
    	  dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
				
			}
		});
    	  dialog.show();
    	 
    	  return true;
    	}

    }

}