


//import android.annotation.SuppressLint
//import android.content.Intent
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import android.widget.Button
//import com.prog.easygeartrack.AddGearActivity
//import com.prog.easygeartrack.GearItem
//import com.prog.easygeartrack.GearAdapter
//import com.prog.easygeartrack.R
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var gearAdapter: GearAdapter
//    private lateinit var gearItemList: MutableList<GearItem>
//    private lateinit var buttonAddGear: Button
//
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        recyclerView = findViewById(R.id.recyclerViewGearCatalog)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        gearItemList = mutableListOf()
//        gearItemList.add(GearItem("Tennis Racket", "Tennis", "Good"))
//        gearItemList.add(GearItem("Baseball Bat", "Baseball", "Excellent"))
//        gearItemList.add(GearItem("Golf Clubs", "Golf", "Fair"))
//
//        gearAdapter = GearAdapter(this, gearItemList)
//        recyclerView.adapter = gearAdapter
//
//        buttonAddGear = findViewById(R.id.buttonSaveGear)
//        buttonAddGear.setOnClickListener {
//            val intent = Intent(this@MainActivity, AddGearActivity::class.java)
//            startActivityForResult(intent, ADD_GEAR_REQUEST_CODE)
//        }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == ADD_GEAR_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
//            val newGearItem = data.getParcelableExtra<GearItem>(EXTRA_GEAR_ITEM)
//            newGearItem?.let {
//                gearItemList.add(newGearItem)
//                gearAdapter.notifyDataSetChanged()
//            }
//        }
//    }
//
//    companion object {
//        const val ADD_GEAR_REQUEST_CODE = 1001
//        const val EXTRA_GEAR_ITEM = "extra_gear_item"
//    }
//}
