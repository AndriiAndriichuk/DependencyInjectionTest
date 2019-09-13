package com.ciuc.andrii.daggertest.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.airbnb.lottie.LottieAnimationView
import com.ciuc.andrii.daggertest.R
import com.ciuc.andrii.daggertest.model.custom_garage.DaggerCustomGarageComponent
import com.ciuc.andrii.daggertest.model.custom_garage.bike.BikeModule
import com.ciuc.andrii.daggertest.model.custom_garage.bike.animation.CarAnimation
import com.ciuc.andrii.daggertest.model.custom_garage.bike.bike_body.BikeBody
import com.ciuc.andrii.daggertest.model.custom_garage.bike.steering_wheel.SteeringWheel
import com.ciuc.andrii.daggertest.model.custom_garage.car.CarModule
import com.ciuc.andrii.daggertest.model.custom_garage.car.animation.BikeAnimation
import com.ciuc.andrii.daggertest.model.custom_garage.car.engine.Block
import com.ciuc.andrii.daggertest.model.custom_garage.car.engine.Cylinders
import com.ciuc.andrii.daggertest.model.custom_garage.car.engine.Engine
import com.ciuc.andrii.daggertest.model.custom_garage.car.engine.SparkPlugs
import com.ciuc.andrii.daggertest.model.custom_garage.car.wheel.Disk
import com.ciuc.andrii.daggertest.model.custom_garage.car.wheel.Tires
import com.ciuc.andrii.daggertest.model.custom_garage.car.wheel.Wheel
import com.ciuc.andrii.daggertest.model.garage.DaggerGarageComponent
import com.ciuc.andrii.daggertest.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        btnCreateGarage.setOnClickListener {

            val garageComponent = DaggerGarageComponent.create()
            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val rowView = inflater.inflate(R.layout.garage_view, null)
            val animateTank = rowView.findViewById<LottieAnimationView>(R.id.animationTank)
            addChildToViewGroup(linear, rowView)

            val tractor = garageComponent.tractor
        }

        btnCreateCustomGarage.setOnClickListener {
            showAddCustomGarageDialog()
        }

    }
    private fun showAddCustomGarageDialog() {
        var thisDialog = Dialog(this)
        thisDialog.setCancelable(true)
        thisDialog.setContentView(R.layout.dialog_add_custom_garage)

        var currentCarStyle = "car_blue.json"
        var currentBikeStyle = "bike_violet.json"

        val btnAddCustomGarage = thisDialog.findViewById<Button>(R.id.btnAddGarage)

        val switchCarStyle = thisDialog.findViewById<Switch>(R.id.switchCarStyle)
        val switchBikeStyle = thisDialog.findViewById<Switch>(R.id.switchBikeStyle)

        val animationCarStyle = thisDialog.findViewById<LottieAnimationView>(R.id.animationCarStyle)
        val animationBikeStyle = thisDialog.findViewById<LottieAnimationView>(R.id.animationBikeStyle)

        switchCarStyle.setOnCheckedChangeListener { _, isChecked ->
            currentCarStyle = if (isChecked) {
                "car_yellow.json"
            } else {
                "car_blue.json"
            }
            animationCarStyle.setAnimation(currentCarStyle)
            animationCarStyle.playAnimation()
            animationCarStyle.loop(true)
        }

        switchBikeStyle.setOnCheckedChangeListener { _, isChecked ->
            currentBikeStyle = if (isChecked) {
                "bike_yellow.json"
            } else {
                "bike_violet.json"
            }
            animationBikeStyle.setAnimation(currentBikeStyle)
            animationBikeStyle.playAnimation()
            animationBikeStyle.loop(true)
        }

        btnAddCustomGarage.setOnClickListener {
            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val rowView = inflater.inflate(R.layout.custom_garage_view, null)
            val animateCar = rowView.findViewById<LottieAnimationView>(R.id.animationCar)
            val animateBike = rowView.findViewById<LottieAnimationView>(R.id.animationBike)


            val customGarageComponent = DaggerCustomGarageComponent
                    .builder()
                    .bikeModule(BikeModule(BikeBody(), SteeringWheel(), BikeAnimation(currentBikeStyle)))
                    .carModule(CarModule(Wheel(Disk(), Tires()), Engine(Block(), Cylinders(), SparkPlugs()), CarAnimation(currentCarStyle)))
                    .build()

            val car = customGarageComponent.car
            val bike = customGarageComponent.bike

            animateCar.setAnimation(currentCarStyle)
            animateBike.setAnimation(bike.bikeAnimation.animationName)

            addChildToViewGroup(linear, rowView)

            thisDialog.cancel()
        }
        thisDialog.show()
    }

    private fun addChildToViewGroup(parentView: ViewGroup, childView: View) {
        val lp = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                300
        )
        parentView.addView(childView, lp)
    }
}
