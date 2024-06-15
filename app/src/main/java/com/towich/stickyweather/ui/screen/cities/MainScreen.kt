package com.towich.stickyweather.ui.screen.cities

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen(navigateToInfoScreen: () -> Unit) {

    val cities = listOf(
        "Архангельск",
        "Барнаул",
        "Владивосток",
        "Воронеж",
        "Екатеринбург",
        "Ижевск",
        "Иркутск",
        "Казань",
        "Краснодар",
        "Красноярск",
        "Кузнецк",
        "Липецк",
        "Москва",
        "Нижний Новгород",
        "Новосибирск",
        "Омск",
        "Оренбург",
        "Пермь",
        "Ростов-на-Дону",
        "Самара",
        "Санкт-Петербург",
        "Саратов",
        "Сочи",
        "Тольятти",
        "Томск",
        "Тюмень",
        "Уфа",
        "Ульяновск",
        "Хабаровск",
        "Челябинск",
        "Ярославль"
    )


    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val groupedNames = remember(cities) {
            cities.groupBy { it.first() }
        }

        val startIndexes = remember(cities) {
            getStartIndexes(groupedNames.entries)
        }

        val endIndexes = remember(cities) {
            getEndIndexes(groupedNames.entries)
        }

        val commonModifier = Modifier.width(50.dp)
        val listState = rememberLazyListState()

        val moveStickyHeader by remember {
            derivedStateOf {
                endIndexes.contains(listState.firstVisibleItemIndex + 1)
            }
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = listState,
        ) {
            itemsIndexed(cities) { index, name ->
                NameItem(
                    name,
                    showCharHeader = startIndexes.contains(index) && listState.firstVisibleItemIndex != index,
                    commonModifier,
                    navigateToInfoScreen = navigateToInfoScreen
                )
            }
        }
        LetterHeader(
            char = cities[listState.firstVisibleItemIndex].first().toString(),
            modifier = commonModifier.then(
                if (moveStickyHeader) {
                    Modifier.offset {
                        IntOffset(0, -listState.firstVisibleItemScrollOffset)
                    }
                } else {
                    Modifier
                }
            )
        )
    }
}

@Composable
fun LetterHeader(char: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(40.dp),
        contentAlignment = Alignment.Center
    )
    {
        Text(
            text = char,
            color = Color(0xFF000000),
            fontSize = 24.sp,
        )
    }
}

@Composable
fun NameItem(
    name: String,
    showCharHeader: Boolean,
    modifier: Modifier,
    navigateToInfoScreen: () -> Unit
) {
    Row(
        Modifier
            .height(56.dp)
            .fillMaxWidth(),
//            .clickable {
//                navigateToInfoScreen()
//            }
    ) {
        if (showCharHeader) {
            LetterHeader(
                char = name.first().toString(),
                modifier = modifier
            )
        } else {
            Spacer(modifier = modifier)
        }

        Text(
            text = name,
            color = Color(0xFF000000),
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
        )

    }
}

private fun getStartIndexes(entries: Set<Map.Entry<Char, List<String>>>): List<Int> {
    var acc = 0
    val list = mutableListOf<Int>()
    entries.forEach { entry ->
        list.add(acc)
        acc += entry.value.size
    }
    return list
}

private fun getEndIndexes(entries: Set<Map.Entry<Char, List<String>>>): List<Int> {
    var acc = 0
    val list = mutableListOf<Int>()
    entries.forEach { entry ->
        acc += entry.value.size
        list.add(acc)
    }
    return list
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen {}
}