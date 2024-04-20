package bes.max.sprint_26

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import bes.max.sprint_26.contactdetails.ui.ContactDetailsScreenContent
import bes.max.sprint_26.contactdetails.ui.testModel1
import bes.max.sprint_26.ui.theme.Sprint_26Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        actionBar?.setBackgroundDrawable((getDrawable(R.color.purple_500)))
        actionBar?.setTitle(getString(R.string.action_bar_title))

        setContent {
            Sprint_26Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContactDetailsScreenContent(testModel1)
                }
            }
        }
    }
}