/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.backend

import org.jetbrains.kotlin.fir.FirSession
import org.jetbrains.kotlin.fir.declarations.*
import org.jetbrains.kotlin.ir.declarations.MetadataSource
import org.jetbrains.kotlin.name.Name

sealed class FirMetadataSource(open val fir: FirDeclaration) : MetadataSource {
    val session: FirSession
        get() = fir.session

    override val name: Name?
        get() = when (val fir = fir) {
            is FirConstructor -> Name.special("<init>")
            is FirSimpleFunction -> fir.name
            is FirRegularClass -> fir.name
            is FirProperty -> fir.name
            else -> null
        }

    class File(override val fir: FirFile) : FirMetadataSource(fir), MetadataSource.File

    class Class(override val fir: FirClass<*>) : FirMetadataSource(fir), MetadataSource.Class

    class Function(override val fir: FirFunction<*>) : FirMetadataSource(fir), MetadataSource.Function

    class Property(override val fir: FirProperty) : FirMetadataSource(fir), MetadataSource.Property
}