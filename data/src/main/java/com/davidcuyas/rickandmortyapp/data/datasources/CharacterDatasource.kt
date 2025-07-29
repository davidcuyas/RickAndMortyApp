package com.davidcuyas.rickandmortyapp.data.datasources

import com.davidcuyas.rickandmortyapp.data.datasources.base.CrudBaseDatasource
import com.davidcuyas.rickandmortyapp.domain.entities.Character


interface CharacterDatasource : CrudBaseDatasource<Character, Int>