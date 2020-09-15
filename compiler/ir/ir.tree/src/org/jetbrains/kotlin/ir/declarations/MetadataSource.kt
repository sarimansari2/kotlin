/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.declarations

import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.name.Name

interface MetadataSource {
    val name: Name?

    interface Class : MetadataSource
    interface File : MetadataSource
    interface Function : MetadataSource
    interface Property : MetadataSource
}

sealed class DescriptorMetadataSource(open val descriptor: Named?) : MetadataSource {
    override val name: Name?
        get() = descriptor?.name

    class Class(override val descriptor: ClassDescriptor) : DescriptorMetadataSource(descriptor), MetadataSource.Class

    class File(val descriptors: List<DeclarationDescriptor>) : DescriptorMetadataSource(null), MetadataSource.File

    class Function(override val descriptor: FunctionDescriptor) : DescriptorMetadataSource(descriptor), MetadataSource.Function

    class Property(override val descriptor: PropertyDescriptor) : DescriptorMetadataSource(descriptor), MetadataSource.Property

    class LocalDelegatedProperty(override val descriptor: VariableDescriptorWithAccessors) : DescriptorMetadataSource(descriptor),
        MetadataSource.Property
}
