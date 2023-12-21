package codelab.compose.superheroes

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import codelab.compose.superheroes.model.Hero
import codelab.compose.superheroes.model.HeroesRepository.heroes
import codelab.compose.superheroes.ui.theme.SuperheroesTheme

@Composable
fun HeroesMainScreen() {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(heroes) {
            HeroItem(
                hero = it,
                modifier = Modifier
                    .padding(
                        horizontal =
                            dimensionResource(id = R.dimen.padding_medium),
                        vertical = 
                            dimensionResource(id = R.dimen.padding_small)
                    )
            )
        }
    }
}
//@Preview()
//@Composable
//fun ListPreview() {
//    HeroesMainScreen()
//}

@Composable
fun HeroItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = modifier
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
                //.sizeIn(minHeight = 16.dp)
        ) {

            HeroInformation(
                heroName = hero.nameRes,
                heroDescription = hero.descriptionRes,
                modifier = Modifier
                    .weight(1f)
                        .padding(end = dimensionResource(R.dimen.padding_small))
            )
            //Spacer()
            HeroImage(heroImage = hero.imageRes)
        }
    }
}
@Composable
fun HeroInformation(
    @StringRes heroName: Int,
    @StringRes heroDescription: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier){
        Text(
            text = stringResource(heroName),
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(heroDescription),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
@Composable
fun HeroImage(
    @DrawableRes heroImage: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(id = R.dimen.image_size))
            //.padding(dimensionResource(id = R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.FillWidth,
        painter = painterResource(heroImage),
        contentDescription = null
    )
}




@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HeroCardPreview() {
    SuperheroesTheme(
        dynamicColor = false
    ) {
        HeroItem(
            Hero(
                R.string.hero1,
                R.string.description1,
                R.drawable.android_superhero1
            )
        )
    }

}