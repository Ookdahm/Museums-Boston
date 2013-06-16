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

public class MapsHistory<PointLocation> extends MapActivity {
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
               
        GeoPoint point03 = new GeoPoint((int) (42.35793*1E6), (int) (-71.062503*1E6));
        OverlayItem overlayitem03 = new OverlayItem(point03, 
        		"Museum of African American History", "14 Beacon St., Suite 719, Boston, MA 02108");
        
        GeoPoint point04 = new GeoPoint((int) (42.338673*1E6), (int) (-71.098301*1E6));
        OverlayItem overlayitem04 = new OverlayItem(point04, 
        		"Isabella Stewart Gardner Museum", "280 The Fenway, Boston MA 02115");
        
        GeoPoint point05 = new GeoPoint((int) (42.35495*1E6), (int) (-71.074236*1E6));
        OverlayItem overlayitem05 = new OverlayItem(point05, 
        		"Gibson House Museum", "137 Beacon Street, Boston, MA 02116");
        
        GeoPoint point06 = new GeoPoint((int) (42.314278*1E6), (int) (-71.033258*1E6));
        OverlayItem overlayitem06 = new OverlayItem(point06, 
        		"John F. Kennedy Presidential Library & Museum", "Columbia Point Boston, MA 02125");
        
        GeoPoint point07 = new GeoPoint((int) (42.350742*1E6), (int) (-71.048842*1E6));
        OverlayItem overlayitem07 = new OverlayItem(point07, 
        		"Boston Fire Museum", "344 Congress Street, Boston, MA  02210");
               
        GeoPoint point09 = new GeoPoint((int) (42.358055*1E6), (int) (-71.057814*1E6));
        OverlayItem overlayitem09 = new OverlayItem(point09, 
        		"The Boston Historical Society and Old State House Museum", "206 Washington Street, Boston, Massachusetts 02109");
        
        GeoPoint point10 = new GeoPoint((int) (42.378432*1E6), (int) (-71.115725*1E6));
        OverlayItem overlayitem10 = new OverlayItem(point10, 
        		"Harvard Museum of Natural History", "26 Oxford Street, Cambridge, MA 02138");
        
        GeoPoint point11 = new GeoPoint((int) (42.85051*1E6), (int) (-70.910908*1E6));
        OverlayItem overlayitem11 = new OverlayItem(point11, 
        		"Rocky Hill Meeting House", "4 Old Portsmouth Road, Amesbury, Mass. 01913");
        
        GeoPoint point12 = new GeoPoint((int) (42.763813*1E6), (int) (-70.847438*1E6));
        OverlayItem overlayitem12 = new OverlayItem(point12, 
        		"Dole-Little House", "289 High Road, Newbury, Mass. 01951");
        
        GeoPoint point13 = new GeoPoint((int) (42.800024*1E6), (int) (-70.862789*1E6));
        OverlayItem overlayitem13 = new OverlayItem(point13, 
        		"Coffin House", "14 High Road, Newbury, Mass. 01951");
        
        GeoPoint point14 = new GeoPoint((int) (42.800024*1E6), (int) (-70.862789*1E6));
        OverlayItem overlayitem14 = new OverlayItem(point14, 
        		"Swett-Ilsley House", "4 High Road, Newbury, Mass. 01951");
        
        GeoPoint point15 = new GeoPoint((int) (42.770819*1E6), (int) (-70.843251*1E6));
        OverlayItem overlayitem15 = new OverlayItem(point15, 
        		"Spencer-Peirce-Little Farm", "5 Little’s Lane, Newbury, Mass. 01951");
        
        GeoPoint point16 = new GeoPoint((int) (42.59109*1E6), (int) (-70.660082*1E6));
        OverlayItem overlayitem16 = new OverlayItem(point16, 
        		"Beauport, Sleeper-McCann House", "75 Eastern Point Boulevard, Gloucester, Mass. 01930");
        
        GeoPoint point17 = new GeoPoint((int) (42.638015*1E6), (int) (-70.776438*1E6));
        OverlayItem overlayitem17 = new OverlayItem(point17, 
        		"Cogswell's Grant", "60 Spring Street, Essex, Mass. 01929");
        
        GeoPoint point18 = new GeoPoint((int) (42.518778*1E6), (int) (-70.89763*1E6));
        OverlayItem overlayitem18 = new OverlayItem(point18, 
        		"Gedney House", "21 High Street, Salem, Mass. 01970");
        
        GeoPoint point19 = new GeoPoint((int) (42.519365*1E6), (int) (-70.902624*1E6));
        OverlayItem overlayitem19 = new OverlayItem(point19, 
        		"Phillips House", "34 Chestnut Street, Salem, Mass. 01970");
        
        GeoPoint point20 = new GeoPoint((int) (42.472101*1E6), (int) (-71.037981*1E6));
        OverlayItem overlayitem20 = new OverlayItem(point20, 
        		"Boardman House", "17 Howard Street, Saugus, Mass. 01906");
        
        GeoPoint point21 = new GeoPoint((int) (42.38433*1E6), (int) (-71.121845*1E6));
        OverlayItem overlayitem21 = new OverlayItem(point21, 
        		"Cooper-Frost-Austin House", "21 Linnaean Street, Cambridge, Mass. 02138");
        
        GeoPoint point22 = new GeoPoint((int) (42.430093*1E6), (int) (-71.332579*1E6));
        OverlayItem overlayitem22 = new OverlayItem(point22, 
        		"Gropius House", "68 Baker Bridge Road, Lincoln, Mass. 01773");
        
        GeoPoint point23 = new GeoPoint((int) (42.383859*1E6), (int) (-71.230325*1E6));
        OverlayItem overlayitem23 = new OverlayItem(point23, 
        		"Lyman Estate", "185 Lyman Street, Waltham, Mass. 02452");
        
        GeoPoint point24 = new GeoPoint((int) (42.372113*1E6), (int) (-71.2006*1E6));
        OverlayItem overlayitem24 = new OverlayItem(point24, 
        		"Browne House", "562 Main Street, Watertown, Mass. 02472");
        
        GeoPoint point25 = new GeoPoint((int) (42.361289*1E6), (int) (-71.064188*1E6));
        OverlayItem overlayitem25 = new OverlayItem(point25, 
        		"Otis House", "141 Cambridge Street, Boston, Mass. 02114");
        
        GeoPoint point26 = new GeoPoint((int) (42.286928*1E6), (int) (-71.05326*1E6));
        OverlayItem overlayitem26 = new OverlayItem(point26, 
        		"Pierce House", "24 Oakton Avenue, Dorchester, Mass. 02122");
        
        GeoPoint point27 = new GeoPoint((int) (42.271759*1E6), (int) (-71.014808*1E6));
        OverlayItem overlayitem27 = new OverlayItem(point27, 
        		"Quincy House", "20 Muirhead Street, Quincy, Mass. 02170");
        
        GeoPoint point28 = new GeoPoint((int) (41.664419*1E6), (int) (-70.171822*1E6));
        OverlayItem overlayitem28 = new OverlayItem(point28, 
        		"Winslow Crocker House", "250 Main Street, Yarmouth Port, Mass. 02675");
        
        GeoPoint point29 = new GeoPoint((int) (42.282441*1E6), (int) (-73.312767*1E6));
        OverlayItem overlayitem29 = new OverlayItem(point29, 
        		"Merwin House", "14 Main Street, Stockbridge, Mass. 01262");
        
        GeoPoint point30 = new GeoPoint((int) (42.352823*1E6), (int) (-71.043059*1E6));
        OverlayItem overlayitem30 = new OverlayItem(point30, 
        		"The Institute of Contemporary Art", "100 Northern Avenue, Boston, MA 02210");
        
        GeoPoint point31 = new GeoPoint((int) (42.345121*1E6), (int) (-71.086353*1E6));
        OverlayItem overlayitem31 = new OverlayItem(point31, 
        		"The Mary Baker Eddy Library", "200 Massachusetts Avenue, Boston, MA 02115");
        
        GeoPoint point32 = new GeoPoint((int) (42.36195*1E6), (int) (-71.097706*1E6));
        OverlayItem overlayitem32 = new OverlayItem(point32, 
        		"MIT Museum", "265 Massachusetts Ave, Cambridge, MA 02139");
        
        GeoPoint point33 = new GeoPoint((int) (42.35848*1E6), (int) (-71.065918*1E6));
        OverlayItem overlayitem33 = new OverlayItem(point33, 
        		"Nichols House Museum", "55 Mount Vernon Street, Boston, Massachusetts 02108");
        
        GeoPoint point34 = new GeoPoint((int) (42.357087*1E6), (int) (-71.05867*1E6));
        OverlayItem overlayitem34 = new OverlayItem(point34, 
        		"Old South Meeting House", "310 Washington Street, Boston, MA 02108");
        
        GeoPoint point35 = new GeoPoint((int) (42.363735*1E6), (int) (-71.05419*1E6));
        OverlayItem overlayitem35 = new OverlayItem(point35, 
        		"Paul Revere House", "19 North Square, Boston, MA 02113");
        
        GeoPoint point36 = new GeoPoint((int) (42.365583*1E6), (int) (-71.062278*1E6));
        OverlayItem overlayitem36 = new OverlayItem(point36, 
        		"Sports Museum Of New England", "100 Legends Way, Boston, MA 02114");
        
        GeoPoint point37 = new GeoPoint((int) (42.360301*1E6), (int) (-71.067264*1E6));
        OverlayItem overlayitem37 = new OverlayItem(point37, 
        		"The Vilna Shul", "18 Phillips Street, Boston, MA 02114");
        
        GeoPoint point38 = new GeoPoint((int) (42.641595*1E6), (int) (-71.316653*1E6));
        OverlayItem overlayitem38 = new OverlayItem(point38, 
        		"American Textile History Museum", "491 Dutton Street Lowell, MA 01854");
        
        GeoPoint point39 = new GeoPoint((int) (42.457678*1E6), (int) (-71.342079*1E6));
        OverlayItem overlayitem39 = new OverlayItem(point39, 
        		"Concord Museum", "53 Cambridge Turnpike, Concord, MA 01742");
        
        GeoPoint point40 = new GeoPoint((int) (42.324273*1E6), (int) (-71.16113*1E6));
        OverlayItem overlayitem40 = new OverlayItem(point40, 
        		"Longyear Museum", "1125 Boylston Street, Chestnut Hill, MA 02467-1811");
        
        GeoPoint point41 = new GeoPoint((int) (42.459127*1E6), (int) (-71.335274*1E6));
        OverlayItem overlayitem41 = new OverlayItem(point41, 
        		"Louisa May Alcott's Orchard House", "399 Lexington Road, Concord, MA");
        
        GeoPoint point42 = new GeoPoint((int) (42.462623*1E6), (int) (-70.943542*1E6));
        OverlayItem overlayitem42 = new OverlayItem(point42, 
        		"The Lynn Museum & Historical Society", "590 Washington Street, Lynn, MA 01901");
        
        GeoPoint point43 = new GeoPoint((int) (42.436*1E6), (int) (-71.214709*1E6));
        OverlayItem overlayitem43 = new OverlayItem(point43, 
        		"National Heritage Museum", "33 Marrett Road, Lexington, MA 02421");
        
        GeoPoint point44 = new GeoPoint((int) (42.468515*1E6), (int) (-71.349334*1E6));
        OverlayItem overlayitem44 = new OverlayItem(point44, 
        		"The Old Manse", "269 Monument Street, Concord, MA");
        
        GeoPoint point46 = new GeoPoint((int) (42.386719*1E6), (int) (-71.229506*1E6));
        OverlayItem overlayitem46 = new OverlayItem(point46, 
        		"Stonehurst, The Robert Treat Paine Estate", "100 Robert Treat Paine Drive, Waltham, MA 02452");
                
        GeoPoint point48 = new GeoPoint((int) (42.248317*1E6), (int) (-71.174525*1E6));
        OverlayItem overlayitem48 = new OverlayItem(point48, 
        		"Dedham Historical Society Museum", "612 High Street, Dedham, MA 02027");
                
        GeoPoint point52 = new GeoPoint((int) (42.367558*1E6), (int) (-71.070701*1E6));
        OverlayItem overlayitem52 = new OverlayItem(point52, 
        		"Museum of Science", "1 Science Park, Boston, MA 02114");
        
        GeoPoint point53 = new GeoPoint((int) (42.377469*1E6), (int) (-71.114124*1E6));
        OverlayItem overlayitem53 = new OverlayItem(point53, 
        		"Peabody Museum of Archaeology & Ethnology", "11 Divinity Ave., Cambridge, MA 02138");
        
        
        
        itemizedOverlay.addOverlay(overlayitem01);
        itemizedOverlay.addOverlay(overlayitem03);
        itemizedOverlay.addOverlay(overlayitem04);
        itemizedOverlay.addOverlay(overlayitem05);
        itemizedOverlay.addOverlay(overlayitem06);
        itemizedOverlay.addOverlay(overlayitem07);
        itemizedOverlay.addOverlay(overlayitem09);
        itemizedOverlay.addOverlay(overlayitem10);
        itemizedOverlay.addOverlay(overlayitem11);
        itemizedOverlay.addOverlay(overlayitem12);
        itemizedOverlay.addOverlay(overlayitem13);
        itemizedOverlay.addOverlay(overlayitem14);
        itemizedOverlay.addOverlay(overlayitem15);
        itemizedOverlay.addOverlay(overlayitem16);
        itemizedOverlay.addOverlay(overlayitem17);
        itemizedOverlay.addOverlay(overlayitem18);
        itemizedOverlay.addOverlay(overlayitem19);
        itemizedOverlay.addOverlay(overlayitem20);
        itemizedOverlay.addOverlay(overlayitem21);
        itemizedOverlay.addOverlay(overlayitem22);
        itemizedOverlay.addOverlay(overlayitem23);
        itemizedOverlay.addOverlay(overlayitem24);
        itemizedOverlay.addOverlay(overlayitem25);
        itemizedOverlay.addOverlay(overlayitem26);
        itemizedOverlay.addOverlay(overlayitem27);
        itemizedOverlay.addOverlay(overlayitem28);
        itemizedOverlay.addOverlay(overlayitem29);
        itemizedOverlay.addOverlay(overlayitem30);
        itemizedOverlay.addOverlay(overlayitem31);
        itemizedOverlay.addOverlay(overlayitem32);
        itemizedOverlay.addOverlay(overlayitem33);
        itemizedOverlay.addOverlay(overlayitem34);
        itemizedOverlay.addOverlay(overlayitem35);
        itemizedOverlay.addOverlay(overlayitem36);
        itemizedOverlay.addOverlay(overlayitem37);
        itemizedOverlay.addOverlay(overlayitem38);
        itemizedOverlay.addOverlay(overlayitem39);
        itemizedOverlay.addOverlay(overlayitem40);
        itemizedOverlay.addOverlay(overlayitem41);
        itemizedOverlay.addOverlay(overlayitem42);
        itemizedOverlay.addOverlay(overlayitem43);
        itemizedOverlay.addOverlay(overlayitem44);
        itemizedOverlay.addOverlay(overlayitem46);
        itemizedOverlay.addOverlay(overlayitem48);
        itemizedOverlay.addOverlay(overlayitem52);
        itemizedOverlay.addOverlay(overlayitem53);
        
        
        
        
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
    	  AlertDialog.Builder dialog = new AlertDialog.Builder(MapsHistory.this);
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