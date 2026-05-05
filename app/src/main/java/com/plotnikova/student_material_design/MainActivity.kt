package com.plotnikova.student_material_design

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.plotnikova.student_material_design.data.Student
import com.plotnikova.student_material_design.data.students
import com.plotnikova.student_material_design.ui.theme.Student_Material_DesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Student_Material_DesignTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StudentApp()
                }
            }
        }
    }
}

@Composable
fun StudentIcon(@DrawableRes studentIcon: Int) {
    Image(
        painter = painterResource(studentIcon),
        contentDescription = null,
        modifier = Modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
    )
}

@Composable
fun StudentInformation(
    @StringRes studentName: Int,
    studentAge: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(studentName),
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = stringResource(R.string.years_old_format, studentAge),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun StudentItem(student: Student) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_small))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            StudentIcon(student.imageResourceId)
            StudentInformation(student.name, student.age)
        }
    }
}

@Composable
fun StudentApp() {
    LazyColumn {
        items(students) { student ->
            StudentItem(student)
        }
    }
}

@Preview
@Composable
fun StudentDarkThemePreview() {
    Student_Material_DesignTheme(darkTheme = true) {
        StudentApp()
    }
}