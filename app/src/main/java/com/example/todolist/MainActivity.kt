package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //
        setContentView(binding.root)

        //validate input and calls addCheckBox function
        binding.addBtn.setOnClickListener(){
            if(binding.itemsInput.text.isNotEmpty()){
                addCheckBox(binding.itemsInput.text.toString())
                binding.itemsInput.text.clear()
            }else{
                Toast.makeText(this, "Please add any input.", Toast.LENGTH_SHORT).show()
            }
        }

    }

    //add check box items to the linear layout
    private fun addCheckBox(todoData: String){
            val checkBox = CheckBox(this)
            checkBox.text = todoData
            checkBox.isChecked = false
            binding.todoList.addView(checkBox)
    }
}