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

public class MapsArt<PointLocation> extends MapActivity {
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
        
    	GeoPoint point01 = new GeoPoint((int) (42.339064*1E6), (int) (-71.093818*1E6));
        OverlayItem overlayitem01 = new OverlayItem(point01, 
        		"Museum of Fine Arts", "465 Huntington Avenue, Boston, Massachusetts 02115");

        GeoPoint point04 = new GeoPoint((int) (42.338673*1E6), (int) (-71.098301*1E6));
        OverlayItem overlayitem04 = new OverlayItem(point04, 
        		"Isabella Stewart Gardner Museum", "280 The Fenway, Boston MA 02115");
        
        
        
        GeoPoint point30 = new GeoPoint((int) (42.352823*1E6), (int) (-71.043059*1E6));
        OverlayItem overlayitem30 = new OverlayItem(point30, 
        		"The Institute of Contemporary Art", "100 Northern Avenue, Boston, MA 02210");
        
        GeoPoint point43 = new GeoPoint((int) (42.436*1E6), (int) (-71.214709*1E6));
        OverlayItem overlayitem43 = new OverlayItem(point43, 
        		"National Heritage Museum", "33 Marrett Road, Lexington, MA 02421");
             
        GeoPoint point45 = new GeoPoint((int) (42.521783*1E6), (int) (-70.892778*1E6));
        OverlayItem overlayitem45 = new OverlayItem(point45, 
        		"Peabody Essex Museum", "161 Essex Street, Salem, MA 01970");
                
        GeoPoint point47 = new GeoPoint((int) (42.037569*1E6), (int) (-70.671124*1E6));
        OverlayItem overlayitem47 = new OverlayItem(point47, 
        		"Art Complex Museum", "189 Alden Street, Box 2814, Duxbury, MA 02331");
        
        GeoPoint point49 = new GeoPoint((int) (42.101805*1E6), (int) (-71.04437*1E6));
        OverlayItem overlayitem49 = new OverlayItem(point49, 
        		"Fuller Craft Museum", "455 Oak Street, Brockton, MA 02301");
        
        GeoPoint point50 = new GeoPoint((int) (42.281348*1E6), (int) (-71.418516*1E6));
        OverlayItem overlayitem50 = new OverlayItem(point50, 
        		"Danforth Museum of Art", "123 Union Avenue, Framingham, MA 01702");
        
        GeoPoint point51 = new GeoPoint((int) (42.292543*1E6), (int) (-71.307008*1E6));
        OverlayItem overlayitem51 = new OverlayItem(point51, 
        		"Davis Museum & Cultural Center", "106 Central Street, Wellesley, MA 02481-8203");
        
        GeoPoint point54 = new GeoPoint((int) (42.431018*1E6), (int) (-71.311299*1E6));
        OverlayItem overlayitem54 = new OverlayItem(point54, 
        		"deCordova Sculpture Park and Museum", "51 Sandy Pond Road, Lincoln, MA 01773");
      
        
        
        itemizedOverlay.addOverlay(overlayitem01);
        itemizedOverlay.addOverlay(overlayitem04);
        itemizedOverlay.addOverlay(overlayitem30);
        itemizedOverlay.addOverlay(overlayitem43);
        itemizedOverlay.addOverlay(overlayitem45);
        itemizedOverlay.addOverlay(overlayitem47);
        itemizedOverlay.addOverlay(overlayitem49);
        itemizedOverlay.addOverlay(overlayitem50);
        itemizedOverlay.addOverlay(overlayitem51);
        itemizedOverlay.addOverlay(overlayitem54);
        
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
    	  AlertDialog.Builder dialog = new AlertDialog.Builder(MapsArt.this);
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