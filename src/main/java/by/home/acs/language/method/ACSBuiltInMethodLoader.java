package by.home.acs.language.method;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ACSBuiltInMethodLoader {
    private static final Set<ACSMethod> methods;

    static {
        final Set<ACSMethod> methodSet = new HashSet<>();
        methodSet.add(new ACSMethod("ACS_ExecuteWait", "null", "null"));
        methodSet.add(new ACSMethod("ACS_NamedExecuteWait", "null", "null"));
        methodSet.add(new ACSMethod("Delay", "null", "null"));
        methodSet.add(new ACSMethod("NamedScriptWait", "null", "null"));
        methodSet.add(new ACSMethod("PolyWait", "null", "null"));
        methodSet.add(new ACSMethod("ScriptWait", "null", "null"));
        methodSet.add(new ACSMethod("TagWait", "null", "null"));
        methodSet.add(new ACSMethod("cos", "null", "null"));
        methodSet.add(new ACSMethod("FixedDiv", "null", "null"));
        methodSet.add(new ACSMethod("FixedMul", "null", "null"));
        methodSet.add(new ACSMethod("Random", "null", "null"));
        methodSet.add(new ACSMethod("sin", "null", "null"));
        methodSet.add(new ACSMethod("StrLen", "null", "null"));
        methodSet.add(new ACSMethod("VectorAngle", "null", "null"));
        methodSet.add(new ACSMethod("ActivatorTID", "null", "null"));
        methodSet.add(new ACSMethod("CheckActorCeilingTexture", "null", "null"));
        methodSet.add(new ACSMethod("CheckActorFloorTexture", "null", "null"));
        methodSet.add(new ACSMethod("CheckPlayerCamera", "null", "null"));
        methodSet.add(new ACSMethod("ClassifyActor", "null", "null"));
        methodSet.add(new ACSMethod("GameSkill", "null", "null"));
        methodSet.add(new ACSMethod("GameType", "null", "null"));
        methodSet.add(new ACSMethod("GetActorAngle", "null", "null"));
        methodSet.add(new ACSMethod("GetActorCeilingZ", "null", "null"));
        methodSet.add(new ACSMethod("GetActorFloorZ", "null", "null"));
        methodSet.add(new ACSMethod("GetActorLightLevel", "null", "null"));
        methodSet.add(new ACSMethod("GetActorPitch", "null", "null"));
        methodSet.add(new ACSMethod("GetActorProperty", "null", "null"));
        methodSet.add(new ACSMethod("GetActorX", "null", "null"));
        methodSet.add(new ACSMethod("GetActorY", "null", "null"));
        methodSet.add(new ACSMethod("GetActorZ", "null", "null"));
        methodSet.add(new ACSMethod("GetAmmoCapacity", "null", "null"));
        methodSet.add(new ACSMethod("GetCVar", "null", "null"));
        methodSet.add(new ACSMethod("GetLevelInfo", "null", "null"));
        methodSet.add(new ACSMethod("GetLineRowOffset", "null", "null"));
        methodSet.add(new ACSMethod("GetPlayerInfo", "null", "null"));
        methodSet.add(new ACSMethod("GetPlayerInput", "null", "null"));
        methodSet.add(new ACSMethod("GetScreenHeight", "null", "null"));
        methodSet.add(new ACSMethod("GetScreenWidth", "null", "null"));
        methodSet.add(new ACSMethod("GetSectorCeilingZ", "null", "null"));
        methodSet.add(new ACSMethod("GetSectorFloorZ", "null", "null"));
        methodSet.add(new ACSMethod("GetSectorLightLevel", "null", "null"));
        methodSet.add(new ACSMethod("GetSigilPieces", "null", "null"));
        methodSet.add(new ACSMethod("LineSide", "null", "null"));
        methodSet.add(new ACSMethod("PlayerClass", "null", "null"));
        methodSet.add(new ACSMethod("PlayerCount", "null", "null"));
        methodSet.add(new ACSMethod("PlayerFrags", "null", "null"));
        methodSet.add(new ACSMethod("PlayerInGame", "null", "null"));
        methodSet.add(new ACSMethod("PlayerIsBot", "null", "null"));
        methodSet.add(new ACSMethod("PlayerNumber", "null", "null"));
        methodSet.add(new ACSMethod("SetResultValue", "null", "null"));
        methodSet.add(new ACSMethod("StrCmp", "null", "null"));
        methodSet.add(new ACSMethod("StrIcmp", "null", "null"));
        methodSet.add(new ACSMethod("ThingCount", "null", "null"));
        methodSet.add(new ACSMethod("ThingCountName", "null", "null"));
        methodSet.add(new ACSMethod("ThingCountNameSector", "null", "null"));
        methodSet.add(new ACSMethod("ThingCountSector", "null", "null"));
        methodSet.add(new ACSMethod("Timer", "null", "null"));
        methodSet.add(new ACSMethod("ActivatorSound", "null", "null"));
        methodSet.add(new ACSMethod("AmbientSound", "null", "null"));
        methodSet.add(new ACSMethod("LocalAmbientSound", "null", "null"));
        methodSet.add(new ACSMethod("LocalSetMusic", "null", "null"));
        methodSet.add(new ACSMethod("SectorSound", "null", "null"));
        methodSet.add(new ACSMethod("SetMusic", "null", "null"));
        methodSet.add(new ACSMethod("SoundSequence", "null", "null"));
        methodSet.add(new ACSMethod("ThingSound", "null", "null"));
        methodSet.add(new ACSMethod("CheckActorInventory", "null", "null"));
        methodSet.add(new ACSMethod("CheckInventory", "null", "null"));
        methodSet.add(new ACSMethod("CheckWeapon", "null", "null"));
        methodSet.add(new ACSMethod("ClearActorInventory", "null", "null"));
        methodSet.add(new ACSMethod("ClearInventory", "null", "null"));
        methodSet.add(new ACSMethod("GiveActorInventory", "null", "null"));
        methodSet.add(new ACSMethod("GiveInventory", "null", "null"));
        methodSet.add(new ACSMethod("SetWeapon", "null", "null"));
        methodSet.add(new ACSMethod("TakeActorInventory", "null", "null"));
        methodSet.add(new ACSMethod("TakeInventory", "null", "null"));
        methodSet.add(new ACSMethod("UseActorInventory", "null", "null"));
        methodSet.add(new ACSMethod("UseInventory", "null", "null"));
        methodSet.add(new ACSMethod("HudMessage", "null", "null"));
        methodSet.add(new ACSMethod("HudMessageBold", "null", "null"));
        methodSet.add(new ACSMethod("Log", "null", "null"));
        methodSet.add(new ACSMethod("Print", "void", "s", "i", "n", "x"));
        methodSet.add(new ACSMethod("PrintBold", "null", "null"));
        methodSet.add(new ACSMethod("SetFont", "null", "null"));
        methodSet.add(new ACSMethod("SetHudClipRect", "null", "null"));
        methodSet.add(new ACSMethod("SetHudSize", "null", "null"));
        methodSet.add(new ACSMethod("SetHudWrapWidth", "null", "null"));
        methodSet.add(new ACSMethod("SetMugShotState", "null", "null"));
        methodSet.add(new ACSMethod("StrParam", "null", "null"));
        methodSet.add(new ACSMethod("StrCpy", "null", "null"));
        methodSet.add(new ACSMethod("ChangeCeiling", "null", "null"));
        methodSet.add(new ACSMethod("ChangeFloor", "null", "null"));
        methodSet.add(new ACSMethod("ChangeLevel", "null", "null"));
        methodSet.add(new ACSMethod("ChangeSky", "null", "null"));
        methodSet.add(new ACSMethod("ClearLineSpecial", "null", "null"));
        methodSet.add(new ACSMethod("Radius_Quake2", "null", "null"));
        methodSet.add(new ACSMethod("ReplaceTextures", "null", "null"));
        methodSet.add(new ACSMethod("SectorDamage", "null", "null"));
        methodSet.add(new ACSMethod("SetAirControl", "null", "null"));
        methodSet.add(new ACSMethod("SetCameraToTexture", "null", "null"));
        methodSet.add(new ACSMethod("SetCeilingTrigger", "null", "null"));
        methodSet.add(new ACSMethod("SetFloorTrigger", "null", "null"));
        methodSet.add(new ACSMethod("SetGravity", "null", "null"));
        methodSet.add(new ACSMethod("SetLineBlocking", "null", "null"));
        methodSet.add(new ACSMethod("SetLineMonsterBlocking", "null", "null"));
        methodSet.add(new ACSMethod("SetLineSpecial", "null", "null"));
        methodSet.add(new ACSMethod("SetLineTexture", "null", "null"));
        methodSet.add(new ACSMethod("CancelFade", "null", "null"));
        methodSet.add(new ACSMethod("CreateTranslation", "null", "null"));
        methodSet.add(new ACSMethod("FadeRange", "null", "null"));
        methodSet.add(new ACSMethod("FadeTo", "null", "null"));
        methodSet.add(new ACSMethod("MorphActor", "null", "null"));
        methodSet.add(new ACSMethod("SetActorAngle", "null", "null"));
        methodSet.add(new ACSMethod("SetActorPitch", "null", "null"));
        methodSet.add(new ACSMethod("SetActorPosition", "null", "null"));
        methodSet.add(new ACSMethod("SetActorProperty", "null", "null"));
        methodSet.add(new ACSMethod("SetActorState", "null", "null"));
        methodSet.add(new ACSMethod("SetAmmoCapacity", "null", "null"));
        methodSet.add(new ACSMethod("SetMarineSprite", "null", "null"));
        methodSet.add(new ACSMethod("SetMarineWeapon", "null", "null"));
        methodSet.add(new ACSMethod("SetSubtitleNumber", "null", "null"));
        methodSet.add(new ACSMethod("SetThingSpecial", "null", "null"));
        methodSet.add(new ACSMethod("Spawn", "null", "null"));
        methodSet.add(new ACSMethod("SpawnProjectile", "null", "null"));
        methodSet.add(new ACSMethod("SpawnSpot", "null", "null"));
        methodSet.add(new ACSMethod("SpawnSpotFacing", "null", "null"));
        methodSet.add(new ACSMethod("Thing_Damage2", "null", "null"));
        methodSet.add(new ACSMethod("Thing_Projectile2", "null", "null"));
        methodSet.add(new ACSMethod("UnMorphActor", "null", "null"));
        methods = Collections.unmodifiableSet(methodSet);
    }

    public static boolean checkBuiltInMethods(String currentFunction) {
        return methods.stream().anyMatch(acsZcommonMethod -> acsZcommonMethod.getName().equalsIgnoreCase(currentFunction));
    }
}
