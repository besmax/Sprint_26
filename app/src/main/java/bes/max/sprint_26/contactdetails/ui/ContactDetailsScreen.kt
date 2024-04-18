package bes.max.sprint_26.contactdetails.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bes.max.sprint_26.R
import bes.max.sprint_26.contactdetails.domain.model.ContactModel

@Composable
fun ContactDetailsScreenContent(model: ContactModel) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactDetailsScreenAvatar(
            imageRes = model.imageRes,
            name = model.name,
            familyName = model.familyName,
        )

        Spacer(modifier = Modifier.height(8.dp))

        ContactDetailsScreenName(model.name, model.surname, model.familyName, model.isFavorite)

        Spacer(modifier = Modifier.height(36.dp))

        ContactDetailsScreenInfoSection(title = R.string.phone, text = model.phone)

        Spacer(modifier = Modifier.height(8.dp))

        ContactDetailsScreenInfoSection(title = R.string.address, text = model.address)

        Spacer(modifier = Modifier.height(8.dp))

        ContactDetailsScreenInfoSection(title = R.string.email, text = model.email)
    }
}

@Composable
fun ContactDetailsScreenAvatar(@DrawableRes imageRes: Int?, name: String, familyName: String) {
    val initials = name[0].toString() + familyName[0]
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        contentAlignment = Alignment.Center
    ) {

        if (imageRes != null) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = stringResource(
                    R.string.contact_avatar,
                    name + familyName,
                ),
                modifier = Modifier.height(100.dp),
                contentScale = ContentScale.Fit,
            )
        } else {

            Icon(
                painter = painterResource(id = R.drawable.circle),
                contentDescription = stringResource(
                    R.string.contact_avatar,
                    name + familyName,
                ),
                tint = Color.LightGray,
            )

            Text(text = initials)
        }
    }
}

@Composable
fun ContactDetailsScreenName(
    name: String,
    surname: String?,
    familyName: String,
    isFavorite: Boolean
) {
    val fullName = (name + " " + (surname ?: "")).trim()

    Text(text = fullName, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(text = familyName, fontSize = 24.sp, fontWeight = FontWeight.Bold)

        if (isFavorite) {
            Spacer(modifier = Modifier.width(4.dp))

            Icon(
                painter = painterResource(id = android.R.drawable.star_big_on),
                contentDescription = stringResource(id = R.string.contact_fav_icon),
                tint = Color.Unspecified,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
fun ContactDetailsScreenInfoSection(@StringRes title: Int, text: String?) {

    if (!text.isNullOrBlank()) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = stringResource(id = title),
                fontSize = 16.sp,
                style = TextStyle(fontStyle = FontStyle.Italic),
                textAlign = TextAlign.End,
                modifier = Modifier
                    .weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = text, fontSize = 14.sp, modifier = Modifier.weight(1f))

        }
    }
}

@Preview
@Composable
fun ContactDetailsScreenContentPreview1() {
    ContactDetailsScreenContent(testModel2)
}

@Preview
@Composable
fun ContactDetailsScreenContentPreview2() {
    ContactDetailsScreenContent(testModel1)
}
