package muffin.experiments.cookmatch

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*

public class FirebaseAPI {

    fun takeAll(referenceName: String, completion: (MutableList<DataSnapshot>) -> Unit) {
        val listOfPartners = mutableListOf<DataSnapshot>()
        FirebaseDatabase.getInstance().getReference(referenceName)
            .addListenerForSingleValueEvent(object :
                ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    var count = 1
                    for (partnerSnapshot in dataSnapshot.children) {
                        listOfPartners.add(dataSnapshot.child(count.toString()))
                        count++
                    }
                    completion(listOfPartners)
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    //Обработка ошибки
                    println("Failed to read value: ${databaseError.toException()}")
                }
            })
    }

    fun takeOne(referenceName: String, uid: Int, completion: (DataSnapshot) -> Unit) {
        FirebaseDatabase.getInstance().getReference(referenceName).child(uid.toString())
            .addListenerForSingleValueEvent(object :
                ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    completion(dataSnapshot)
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Обработка ошибки
                    Log.e("FirebaseError", "Failed to read the value", databaseError.toException())
                }
            })
    }

}
