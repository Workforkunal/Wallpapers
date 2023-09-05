package com.app.wallpapers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.wallpapers.data.Datasource
import com.app.wallpapers.model.Walls
import com.app.wallpapers.ui.theme.WallpapersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WallpapersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WallGrid(modifier = Modifier.padding(
                        dimensionResource(id = R.dimen.padding_small)
                    ))
                }
            }
        }
    }
}
@Composable
fun WallGrid(modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
    ){
        items(Datasource.wall){wall ->
            WallCard(wall)
        }
    }
}
@Composable
fun WallCard(walls: Walls, modifier: Modifier = Modifier) {
    Card {
        Row {
            Box {
                Image(
                    painter = painterResource(id = walls.imageRes) ,
                    contentDescription = null,
                    modifier = modifier
                        .size(height = 68.dp, width = 68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }
            Column {
                Text(
                    text = stringResource(id = walls.name),
                    fontSize = 17.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        start = dimensionResource(id = R.dimen.padding_medium) ,
                        top = dimensionResource(id = R.dimen.padding_medium),
                        end = dimensionResource(id = R.dimen.padding_medium),
                        bottom = dimensionResource(id = R.dimen.padding_small)
                    )
                )
                Row {
                    Text(
                        text =walls.availableWallpapers.toString(),
                        fontSize = 17.sp,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier
                            .padding(start = dimensionResource(id = R.dimen.padding_medium)),
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun WallPreview() {
    val walls = Walls(R.string.architecture,45, R.drawable.architecture)
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        WallCard(walls = walls)
    }
}