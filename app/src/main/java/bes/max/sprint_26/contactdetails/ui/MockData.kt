package bes.max.sprint_26.contactdetails.ui

import bes.max.sprint_26.R
import bes.max.sprint_26.contactdetails.domain.model.ContactModel

val testModel1 = ContactModel(
    name = "Compose",
    surname = "Androidovich",
    familyName = "Jetpack",
    isFavorite = true,
    phone = "+7 857 998-55-47",
    address = "Android, Google I/O, 2019",
    email = "sabaka@domen.net",
)

val testModel2 = ContactModel(
    name = "View",
    surname = "Androidovich",
    familyName = "Old",
    imageRes = R.drawable.avatar,
    isFavorite = false,
    phone = "?????",
    address = "Android, Google",
    email = "sabaka@domen.net",
)