package by.home.acs.language.method;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ACSZspecialMethodLoader {
    private static final Set<ACSMethod> zspecialMethods;

    static {
        final Set<ACSMethod> methodSet = new HashSet<>();
        methodSet.add(new ACSMethod("Polyobj_StartLine", "null", "null"));
        methodSet.add(new ACSMethod("Polyobj_RotateLeft", "null", "null"));
        methodSet.add(new ACSMethod("Polyobj_RotateRight", "null", "null"));
        methodSet.add(new ACSMethod("Polyobj_Move", "null", "null"));
        methodSet.add(new ACSMethod("Polyobj_ExplicitLine", "null", "null"));
        methodSet.add(new ACSMethod("Polyobj_MoveTimes", "null", "null"));
        methodSet.add(new ACSMethod("Polyobj_DoorSwing", "null", "null"));
        methodSet.add(new ACSMethod("Polyobj_DoorSlide", "null", "null"));
        methodSet.add(new ACSMethod("Line_Horizon", "null", "null"));
        methodSet.add(new ACSMethod("Door_Close", "null", "null"));
        methodSet.add(new ACSMethod("Door_Open", "null", "null"));
        methodSet.add(new ACSMethod("Door_Raise", "null", "null"));
        methodSet.add(new ACSMethod("Door_LockedRaise", "null", "null"));
        methodSet.add(new ACSMethod("Door_Animated", "null", "null"));
        methodSet.add(new ACSMethod("Autosave", "null", "null"));
        methodSet.add(new ACSMethod("Transfer_WallLight", "null", "null"));
        methodSet.add(new ACSMethod("Thing_Raise", "null", "null"));
        methodSet.add(new ACSMethod("StartConversation", "null", "null"));
        methodSet.add(new ACSMethod("Thing_Stop", "null", "null"));
        methodSet.add(new ACSMethod("Floor_LowerByValue", "null", "null"));
        methodSet.add(new ACSMethod("Floor_LowerToLowest", "null", "null"));
        methodSet.add(new ACSMethod("Floor_LowerToNearest", "null", "null"));
        methodSet.add(new ACSMethod("Floor_RaiseByValue", "null", "null"));
        methodSet.add(new ACSMethod("Floor_RaiseToHighest", "null", "null"));
        methodSet.add(new ACSMethod("Floor_RaiseToNearest", "null", "null"));
        methodSet.add(new ACSMethod("Stairs_BuildDown", "null", "null"));
        methodSet.add(new ACSMethod("Stairs_BuildUp", "null", "null"));
        methodSet.add(new ACSMethod("Floor_RaiseAndCrush", "null", "null"));
        methodSet.add(new ACSMethod("Pillar_Build", "null", "null"));
        methodSet.add(new ACSMethod("Pillar_Open", "null", "null"));
        methodSet.add(new ACSMethod("Stairs_BuildDownSync", "null", "null"));
        methodSet.add(new ACSMethod("Stairs_BuildUpSync", "null", "null"));
        methodSet.add(new ACSMethod("ForceField", "null", "null"));
        methodSet.add(new ACSMethod("ClearForceField", "null", "null"));
        methodSet.add(new ACSMethod("Floor_RaiseByValueTimes", "null", "null"));
        methodSet.add(new ACSMethod("Floor_LowerByValueTimes", "null", "null"));
        methodSet.add(new ACSMethod("Floor_MoveToValue", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_Waggle", "null", "null"));
        methodSet.add(new ACSMethod("Teleport_ZombieChanger", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_LowerByValue", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_RaiseByValue", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_CrushAndRaise", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_LowerAndCrush", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_CrushStop", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_CrushRaiseAndStay", "null", "null"));
        methodSet.add(new ACSMethod("Floor_CrushStop", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_MoveToValue", "null", "null"));
        methodSet.add(new ACSMethod("Sector_AttachdMidtex", "null", "null"));
        methodSet.add(new ACSMethod("GlassBreak", "null", "null"));
        methodSet.add(new ACSMethod("ExtraFloor_LightOnly", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetLink", "null", "null"));
        methodSet.add(new ACSMethod("Scroll_Wall", "null", "null"));
        methodSet.add(new ACSMethod("Line_SetTextureOffset", "null", "null"));
        methodSet.add(new ACSMethod("Sector_ChangeFlags", "null", "null"));
        methodSet.add(new ACSMethod("Line_SetBlocking", "null", "null"));
        methodSet.add(new ACSMethod("Line_SetTextureScale", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetPortal", "null", "null"));
        methodSet.add(new ACSMethod("Sector_CopyScroller", "null", "null"));
        methodSet.add(new ACSMethod("Polyobj_OR_MoveToSpot", "null", "null"));
        methodSet.add(new ACSMethod("Plat_PerpetualRaise", "null", "null"));
        methodSet.add(new ACSMethod("Plat_Stop", "null", "null"));
        methodSet.add(new ACSMethod("Plat_DownWaitUpStay", "null", "null"));
        methodSet.add(new ACSMethod("Plat_DownByValue", "null", "null"));
        methodSet.add(new ACSMethod("Plat_UpWaitDownStay", "null", "null"));
        methodSet.add(new ACSMethod("Plat_UpByValue", "null", "null"));
        methodSet.add(new ACSMethod("Floor_LowerInstant", "null", "null"));
        methodSet.add(new ACSMethod("Floor_RaiseInstant", "null", "null"));
        methodSet.add(new ACSMethod("Floor_MoveToValueTimes", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_MoveToValueTimes", "null", "null"));
        methodSet.add(new ACSMethod("Teleport", "null", "null"));
        methodSet.add(new ACSMethod("Teleport_NoFog", "null", "null"));
        methodSet.add(new ACSMethod("ThrustThing", "null", "null"));
        methodSet.add(new ACSMethod("DamageThing", "null", "null"));
        methodSet.add(new ACSMethod("Teleport_NewMap", "null", "null"));
        methodSet.add(new ACSMethod("Teleport_EndGame", "null", "null"));
        methodSet.add(new ACSMethod("TeleportOther", "null", "null"));
        methodSet.add(new ACSMethod("TeleportGroup", "null", "null"));
        methodSet.add(new ACSMethod("TeleportInSector", "null", "null"));
        methodSet.add(new ACSMethod("Thing_SetConversation", "null", "null"));
        methodSet.add(new ACSMethod("ACS_Execute", "null", "null"));
        methodSet.add(new ACSMethod("ACS_Suspend", "null", "null"));
        methodSet.add(new ACSMethod("ACS_Terminate", "null", "null"));
        methodSet.add(new ACSMethod("ACS_LockedExecute", "null", "null"));
        methodSet.add(new ACSMethod("ACS_ExecuteWithResult", "null", "null"));
        methodSet.add(new ACSMethod("ACS_LockedExecuteDoor", "null", "null"));
        methodSet.add(new ACSMethod("Polyobj_MoveToSpot", "null", "null"));
        methodSet.add(new ACSMethod("Polyobj_Stop", "null", "null"));
        methodSet.add(new ACSMethod("Polyobj_MoveTo", "null", "null"));
        methodSet.add(new ACSMethod("Polyobj_OR_MoveTo", "null", "null"));
        methodSet.add(new ACSMethod("Polyobj_OR_RotateLeft", "null", "null"));
        methodSet.add(new ACSMethod("Polyobj_OR_RotateRight", "null", "null"));
        methodSet.add(new ACSMethod("Polyobj_OR_Move", "null", "null"));
        methodSet.add(new ACSMethod("Polyobj_OR_MoveTimes", "null", "null"));
        methodSet.add(new ACSMethod("Pillar_BuildAndCrush", "null", "null"));
        methodSet.add(new ACSMethod("FloorAndCeiling_LowerByValue", "null", "null"));
        methodSet.add(new ACSMethod("FloorAndCeiling_RaiseByValue", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_LowerAndCrushDist", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetTranslucent", "null", "null"));
        methodSet.add(new ACSMethod("Floor_RaiseAndCrushDoom", "null", "null"));
        methodSet.add(new ACSMethod("Scroll_Texture_Left", "null", "null"));
        methodSet.add(new ACSMethod("Scroll_Texture_Right", "null", "null"));
        methodSet.add(new ACSMethod("Scroll_Texture_Up", "null", "null"));
        methodSet.add(new ACSMethod("Scroll_Texture_Down", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_CrushAndRaiseSilentDist", "null", "null"));
        methodSet.add(new ACSMethod("Door_WaitRaise", "null", "null"));
        methodSet.add(new ACSMethod("Door_WaitClose", "null", "null"));
        methodSet.add(new ACSMethod("Line_SetPortalTarget", "null", "null"));
        methodSet.add(new ACSMethod("Light_ForceLightning", "null", "null"));
        methodSet.add(new ACSMethod("Light_RaiseByValue", "null", "null"));
        methodSet.add(new ACSMethod("Light_LowerByValue", "null", "null"));
        methodSet.add(new ACSMethod("Light_ChangeToValue", "null", "null"));
        methodSet.add(new ACSMethod("Light_Fade", "null", "null"));
        methodSet.add(new ACSMethod("Light_Glow", "null", "null"));
        methodSet.add(new ACSMethod("Light_Flicker", "null", "null"));
        methodSet.add(new ACSMethod("Light_Strobe", "null", "null"));
        methodSet.add(new ACSMethod("Light_Stop", "null", "null"));
        methodSet.add(new ACSMethod("Plane_Copy", "null", "null"));
        methodSet.add(new ACSMethod("Thing_Damage", "null", "null"));
        methodSet.add(new ACSMethod("Radius_Quake", "null", "null"));
        methodSet.add(new ACSMethod("Line_SetIdentification", "null", "null"));
        methodSet.add(new ACSMethod("Thing_Move", "null", "null"));
        methodSet.add(new ACSMethod("Thing_SetSpecial", "null", "null"));
        methodSet.add(new ACSMethod("ThrustThingZ", "null", "null"));
        methodSet.add(new ACSMethod("UsePuzzleItem", "null", "null"));
        methodSet.add(new ACSMethod("Thing_Activate", "null", "null"));
        methodSet.add(new ACSMethod("Thing_Deactivate", "null", "null"));
        methodSet.add(new ACSMethod("Thing_Remove", "null", "null"));
        methodSet.add(new ACSMethod("Thing_Destroy", "null", "null"));
        methodSet.add(new ACSMethod("Thing_Projectile", "null", "null"));
        methodSet.add(new ACSMethod("Thing_Spawn", "null", "null"));
        methodSet.add(new ACSMethod("Thing_ProjectileGravity", "null", "null"));
        methodSet.add(new ACSMethod("Thing_SpawnNoFog", "null", "null"));
        methodSet.add(new ACSMethod("Floor_Waggle", "null", "null"));
        methodSet.add(new ACSMethod("Thing_SpawnFacing", "null", "null"));
        methodSet.add(new ACSMethod("Sector_ChangeSound", "null", "null"));
        methodSet.add(new ACSMethod("Player_RemoveItem", "null", "null"));
        methodSet.add(new ACSMethod("Player_GiveItem", "null", "null"));
        methodSet.add(new ACSMethod("Player_SetTeam", "null", "null"));
        methodSet.add(new ACSMethod("Line_SetHealth", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetHealth", "null", "null"));
        methodSet.add(new ACSMethod("Team_Score", "null", "null"));
        methodSet.add(new ACSMethod("Team_GivePoints", "null", "null"));
        methodSet.add(new ACSMethod("Teleport_NoStop", "null", "null"));
        methodSet.add(new ACSMethod("SetGlobalFogParameter", "null", "null"));
        methodSet.add(new ACSMethod("FS_Execute", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetPlaneReflection", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetDFloor", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetContents", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_CrushAndRaiseDist", "null", "null"));
        methodSet.add(new ACSMethod("Generic_Crusher", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetCeilingScale", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetFloorScale", "null", "null"));
        methodSet.add(new ACSMethod("Plat_UpNearestWaitDownStay", "null", "null"));
        methodSet.add(new ACSMethod("NoiseAlert", "null", "null"));
        methodSet.add(new ACSMethod("SendToCommunicator", "null", "null"));
        methodSet.add(new ACSMethod("Thing_ProjectileIntercept", "null", "null"));
        methodSet.add(new ACSMethod("Thing_ChangeTID", "null", "null"));
        methodSet.add(new ACSMethod("Thing_Hate", "null", "null"));
        methodSet.add(new ACSMethod("Thing_ProjectileAimed", "null", "null"));
        methodSet.add(new ACSMethod("ChangeSkill", "null", "null"));
        methodSet.add(new ACSMethod("Thing_SetTranslation", "null", "null"));
        methodSet.add(new ACSMethod("Plane_Align", "null", "null"));
        methodSet.add(new ACSMethod("Line_Mirror", "null", "null"));
        methodSet.add(new ACSMethod("Line_AlignCeiling", "null", "null"));
        methodSet.add(new ACSMethod("Line_AlignFloor", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetRotation", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetCeilingPanning", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetFloorPanning", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetCeilingScale", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetFloorScale", "null", "null"));
        methodSet.add(new ACSMethod("SetPlayerProperty", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_LowerToHighestFloor", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_LowerInstant", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_RaiseInstant", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_CrushRaiseAndStayA", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_CrushAndRaiseA", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_CrushAndRaiseSilentA", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_RaiseByValueTimes", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_LowerByValueTimes", "null", "null"));
        methodSet.add(new ACSMethod("Generic_Floor", "null", "null"));
        methodSet.add(new ACSMethod("Generic_Ceiling", "null", "null"));
        methodSet.add(new ACSMethod("Generic_Door", "null", "null"));
        methodSet.add(new ACSMethod("Generic_Lift", "null", "null"));
        methodSet.add(new ACSMethod("Generic_Stairs", "null", "null"));
        methodSet.add(new ACSMethod("Generic_Crusher", "null", "null"));
        methodSet.add(new ACSMethod("Plat_DownWaitUpStayLip", "null", "null"));
        methodSet.add(new ACSMethod("Plat_PerpetualRaiseLip", "null", "null"));
        methodSet.add(new ACSMethod("TranslucentLine", "null", "null"));
        methodSet.add(new ACSMethod("Transfer_Heights", "null", "null"));
        methodSet.add(new ACSMethod("Transfer_FloorLight", "null", "null"));
        methodSet.add(new ACSMethod("Transfer_CeilingLight", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetColor", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetFade", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetDamage", "null", "null"));
        methodSet.add(new ACSMethod("Teleport_Line", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetGravity", "null", "null"));
        methodSet.add(new ACSMethod("Stairs_BuildUpDoom", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetWind", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetFriction", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetCurrent", "null", "null"));
        methodSet.add(new ACSMethod("Scroll_Texture_Both", "null", "null"));
        methodSet.add(new ACSMethod("Scroll_Texture_Model", "null", "null"));
        methodSet.add(new ACSMethod("Scroll_Floor", "null", "null"));
        methodSet.add(new ACSMethod("Scroll_Ceiling", "null", "null"));
        methodSet.add(new ACSMethod("Scroll_Texture_Offsets", "null", "null"));
        methodSet.add(new ACSMethod("ACS_ExecuteAlways", "null", "null"));
        methodSet.add(new ACSMethod("PointPush_SetForce", "null", "null"));
        methodSet.add(new ACSMethod("Plat_RaiseAndStayTx", "null", "null"));
        methodSet.add(new ACSMethod("Thing_SetGoal", "null", "null"));
        methodSet.add(new ACSMethod("Plat_UpByValueStayTx", "null", "null"));
        methodSet.add(new ACSMethod("Plat_ToggleCeiling", "null", "null"));
        methodSet.add(new ACSMethod("Light_StrobeDoom", "null", "null"));
        methodSet.add(new ACSMethod("Light_MinNeighbor", "null", "null"));
        methodSet.add(new ACSMethod("Light_MaxNeighbor", "null", "null"));
        methodSet.add(new ACSMethod("Floor_TransferTrigger", "null", "null"));
        methodSet.add(new ACSMethod("Floor_TransferNumeric", "null", "null"));
        methodSet.add(new ACSMethod("ChangeCamera", "null", "null"));
        methodSet.add(new ACSMethod("Floor_RaiseToLowestCeiling", "null", "null"));
        methodSet.add(new ACSMethod("Floor_RaiseByValueTxTy", "null", "null"));
        methodSet.add(new ACSMethod("Floor_RaiseByTexture", "null", "null"));
        methodSet.add(new ACSMethod("Floor_LowerToLowestTxTy", "null", "null"));
        methodSet.add(new ACSMethod("Floor_LowerToHighest", "null", "null"));
        methodSet.add(new ACSMethod("Exit_Normal", "null", "null"));
        methodSet.add(new ACSMethod("Exit_Secret", "null", "null"));
        methodSet.add(new ACSMethod("Elevator_RaiseToNearest", "null", "null"));
        methodSet.add(new ACSMethod("Elevator_MoveToFloor", "null", "null"));
        methodSet.add(new ACSMethod("Elevator_LowerToNearest", "null", "null"));
        methodSet.add(new ACSMethod("HealThing", "null", "null"));
        methodSet.add(new ACSMethod("Door_CloseWaitOpen", "null", "null"));
        methodSet.add(new ACSMethod("Floor_Donut", "null", "null"));
        methodSet.add(new ACSMethod("FloorAndCeiling_LowerRaise", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_RaiseToNearest", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_LowerToLowest", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_LowerToFloor", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_CrushRaiseAndStaySilA", "null", "null"));
        methodSet.add(new ACSMethod("Floor_LowerToHighestEE", "null", "null"));
        methodSet.add(new ACSMethod("Floor_RaiseToLowest", "null", "null"));
        methodSet.add(new ACSMethod("Floor_LowerToLowestCeiling", "null", "null"));
        methodSet.add(new ACSMethod("Floor_RaiseToCeiling", "null", "null"));
        methodSet.add(new ACSMethod("Floor_ToCeilingInstant", "null", "null"));
        methodSet.add(new ACSMethod("Floor_LowerByTexture", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_RaiseToHighest", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_ToHighestInstant", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_LowerToNearest", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_RaiseToLowest", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_RaiseToHighestFloor", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_ToFloorInstant", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_RaiseByTexture", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_LowerByTexture", "null", "null"));
        methodSet.add(new ACSMethod("Stairs_BuildDownDoom", "null", "null"));
        methodSet.add(new ACSMethod("Stairs_BuildUpDoomSync", "null", "null"));
        methodSet.add(new ACSMethod("Stairs_BuildDownDoomSync", "null", "null"));
        methodSet.add(new ACSMethod("Stairs_BuildUpDoomCrush", "null", "null"));
        methodSet.add(new ACSMethod("Door_AnimatedClose", "null", "null"));
        methodSet.add(new ACSMethod("Floor_Stop", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_Stop", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetFloorGlow", "null", "null"));
        methodSet.add(new ACSMethod("Sector_SetCeilingGlow", "null", "null"));
        methodSet.add(new ACSMethod("Floor_MoveToValueAndCrush", "null", "null"));
        methodSet.add(new ACSMethod("Ceiling_MoveToValueAndCrush", "null", "null"));
        methodSet.add(new ACSMethod("Line_SetAutomapFlags", "null", "null"));
        methodSet.add(new ACSMethod("Line_SetAutomapStyle", "null", "null"));
        methodSet.add(new ACSMethod("Portal_Define", "null", "null"));
        methodSet.add(new ACSMethod("Line_QuickPortal", "null", "null"));
        methodSet.add(new ACSMethod("GetLineUDMFInt", "null", "null"));
        methodSet.add(new ACSMethod("GetLineUDMFFixed", "null", "null"));
        methodSet.add(new ACSMethod("GetThingUDMFInt", "null", "null"));
        methodSet.add(new ACSMethod("GetThingUDMFFixed", "null", "null"));
        methodSet.add(new ACSMethod("GetSectorUDMFInt", "null", "null"));
        methodSet.add(new ACSMethod("GetSectorUDMFFixed", "null", "null"));
        methodSet.add(new ACSMethod("GetSideUDMFInt", "null", "null"));
        methodSet.add(new ACSMethod("GetSideUDMFFixed", "null", "null"));
        methodSet.add(new ACSMethod("GetActorVelX", "null", "null"));
        methodSet.add(new ACSMethod("GetActorVelY", "null", "null"));
        methodSet.add(new ACSMethod("GetActorVelZ", "null", "null"));
        methodSet.add(new ACSMethod("SetActivator", "null", "null"));
        methodSet.add(new ACSMethod("SetActivatorToTarget", "null", "null"));
        methodSet.add(new ACSMethod("GetActorViewHeight", "null", "null"));
        methodSet.add(new ACSMethod("GetChar", "null", "null"));
        methodSet.add(new ACSMethod("GetAirSupply", "null", "null"));
        methodSet.add(new ACSMethod("SetAirSupply", "null", "null"));
        methodSet.add(new ACSMethod("SetSkyScrollSpeed", "null", "null"));
        methodSet.add(new ACSMethod("GetArmorType", "null", "null"));
        methodSet.add(new ACSMethod("SpawnSpotForced", "null", "null"));
        methodSet.add(new ACSMethod("SpawnSpotFacingForced", "null", "null"));
        methodSet.add(new ACSMethod("CheckActorProperty", "null", "null"));
        methodSet.add(new ACSMethod("SetActorVelocity", "null", "null"));
        methodSet.add(new ACSMethod("SetUserVariable", "null", "null"));
        methodSet.add(new ACSMethod("GetUserVariable", "null", "null"));
        methodSet.add(new ACSMethod("Radius_Quake", "null", "null"));
        methodSet.add(new ACSMethod("CheckActorClass", "null", "null"));
        methodSet.add(new ACSMethod("SetUserArray", "null", "null"));
        methodSet.add(new ACSMethod("GetUserArray", "null", "null"));
        methodSet.add(new ACSMethod("SoundSequenceOnActor", "null", "null"));
        methodSet.add(new ACSMethod("SoundSequenceOnSector", "null", "null"));
        methodSet.add(new ACSMethod("SoundSequenceOnPolyobj", "null", "null"));
        methodSet.add(new ACSMethod("GetPolyobjX", "null", "null"));
        methodSet.add(new ACSMethod("GetPolyobjY", "null", "null"));
        methodSet.add(new ACSMethod("CheckSight", "null", "null"));
        methodSet.add(new ACSMethod("SpawnForced", "null", "null"));
        methodSet.add(new ACSMethod("AnnouncerSound", "null", "null"));
        methodSet.add(new ACSMethod("SetPointer", "null", "null"));
        methodSet.add(new ACSMethod("ACS_NamedExecute", "null", "null"));
        methodSet.add(new ACSMethod("ACS_NamedSuspend", "null", "null"));
        methodSet.add(new ACSMethod("ACS_NamedTerminate", "null", "null"));
        methodSet.add(new ACSMethod("ACS_NamedLockedExecute", "null", "null"));
        methodSet.add(new ACSMethod("ACS_NamedLockedExecuteDoor", "null", "null"));
        methodSet.add(new ACSMethod("ACS_NamedExecuteWithResult", "null", "null"));
        methodSet.add(new ACSMethod("ACS_NamedExecuteAlways", "null", "null"));
        methodSet.add(new ACSMethod("UniqueTID", "null", "null"));
        methodSet.add(new ACSMethod("IsTIDUsed", "null", "null"));
        methodSet.add(new ACSMethod("Sqrt", "null", "null"));
        methodSet.add(new ACSMethod("FixedSqrt", "null", "null"));
        methodSet.add(new ACSMethod("VectorLength", "null", "null"));
        methodSet.add(new ACSMethod("SetHUDClipRect", "null", "null"));
        methodSet.add(new ACSMethod("SetHUDWrapWidth", "null", "null"));
        methodSet.add(new ACSMethod("SetCVar", "null", "null"));
        methodSet.add(new ACSMethod("GetUserCVar", "null", "null"));
        methodSet.add(new ACSMethod("SetUserCVar", "null", "null"));
        methodSet.add(new ACSMethod("GetCVarString", "null", "null"));
        methodSet.add(new ACSMethod("SetCVarString", "null", "null"));
        methodSet.add(new ACSMethod("GetUserCVarString", "null", "null"));
        methodSet.add(new ACSMethod("SetUserCVarString", "null", "null"));
        methodSet.add(new ACSMethod("LineAttack", "null", "null"));
        methodSet.add(new ACSMethod("PlaySound", "null", "null"));
        methodSet.add(new ACSMethod("StopSound", "null", "null"));
        methodSet.add(new ACSMethod("strcmp", "null", "null"));
        methodSet.add(new ACSMethod("stricmp", "null", "null"));
        methodSet.add(new ACSMethod("strcasecmp", "null", "null"));
        methodSet.add(new ACSMethod("StrLeft", "null", "null"));
        methodSet.add(new ACSMethod("StrRight", "null", "null"));
        methodSet.add(new ACSMethod("StrMid", "null", "null"));
        methodSet.add(new ACSMethod("GetActorClass", "null", "null"));
        methodSet.add(new ACSMethod("GetWeapon", "null", "null"));
        methodSet.add(new ACSMethod("SoundVolume", "null", "null"));
        methodSet.add(new ACSMethod("PlayActorSound", "null", "null"));
        methodSet.add(new ACSMethod("SpawnDecal", "null", "null"));
        methodSet.add(new ACSMethod("CheckFont", "null", "null"));
        methodSet.add(new ACSMethod("DropItem", "null", "null"));
        methodSet.add(new ACSMethod("CheckFlag", "null", "null"));
        methodSet.add(new ACSMethod("SetLineActivation", "null", "null"));
        methodSet.add(new ACSMethod("GetLineActivation", "null", "null"));
        methodSet.add(new ACSMethod("GetActorPowerupTics", "null", "null"));
        methodSet.add(new ACSMethod("ChangeActorAngle", "null", "null"));
        methodSet.add(new ACSMethod("ChangeActorPitch", "null", "null"));
        methodSet.add(new ACSMethod("GetArmorInfo", "null", "null"));
        methodSet.add(new ACSMethod("DropInventory", "null", "null"));
        methodSet.add(new ACSMethod("PickActor", "null", "null"));
        methodSet.add(new ACSMethod("IsPointerEqual", "null", "null"));
        methodSet.add(new ACSMethod("CanRaiseActor", "null", "null"));
        methodSet.add(new ACSMethod("SetActorTeleFog", "null", "null"));
        methodSet.add(new ACSMethod("SwapActorTeleFog", "null", "null"));
        methodSet.add(new ACSMethod("SetActorRoll", "null", "null"));
        methodSet.add(new ACSMethod("ChangeActorRoll", "null", "null"));
        methodSet.add(new ACSMethod("GetActorRoll", "null", "null"));
        methodSet.add(new ACSMethod("QuakeEx", "null", "null"));
        methodSet.add(new ACSMethod("Warp", "null", "null"));
        methodSet.add(new ACSMethod("GetMaxInventory", "null", "null"));
        methodSet.add(new ACSMethod("SetSectorDamage", "null", "null"));
        methodSet.add(new ACSMethod("SetSectorTerrain", "null", "null"));
        methodSet.add(new ACSMethod("SpawnParticle", "null", "null"));
        methodSet.add(new ACSMethod("SetMusicVolume", "null", "null"));
        methodSet.add(new ACSMethod("CheckProximity", "null", "null"));
        methodSet.add(new ACSMethod("CheckActorState", "null", "null"));
        methodSet.add(new ACSMethod("ResetMap", "null", "null"));
        methodSet.add(new ACSMethod("PlayerIsSpectator", "null", "null"));
        methodSet.add(new ACSMethod("ConsolePlayerNumber", "null", "null"));
        methodSet.add(new ACSMethod("GetTeamProperty", "null", "null"));
        methodSet.add(new ACSMethod("GetPlayerLivesLeft", "null", "null"));
        methodSet.add(new ACSMethod("SetPlayerLivesLeft", "null", "null"));
        methodSet.add(new ACSMethod("KickFromGame", "null", "null"));
        methodSet.add(new ACSMethod("GetGamemodeState", "null", "null"));
        methodSet.add(new ACSMethod("SetDBEntry", "null", "null"));
        methodSet.add(new ACSMethod("GetDBEntry", "null", "null"));
        methodSet.add(new ACSMethod("SetDBEntryString", "null", "null"));
        methodSet.add(new ACSMethod("GetDBEntryString", "null", "null"));
        methodSet.add(new ACSMethod("IncrementDBEntry", "null", "null"));
        methodSet.add(new ACSMethod("PlayerIsLoggedIn", "null", "null"));
        methodSet.add(new ACSMethod("GetPlayerAccountName", "null", "null"));
        methodSet.add(new ACSMethod("SortDBEntries", "null", "null"));
        methodSet.add(new ACSMethod("CountDBResults", "null", "null"));
        methodSet.add(new ACSMethod("FreeDBResults", "null", "null"));
        methodSet.add(new ACSMethod("GetDBResultKeyString", "null", "null"));
        methodSet.add(new ACSMethod("GetDBResultValueString", "null", "null"));
        methodSet.add(new ACSMethod("GetDBResultValue", "null", "null"));
        methodSet.add(new ACSMethod("GetDBEntryRank", "null", "null"));
        methodSet.add(new ACSMethod("RequestScriptPuke", "null", "null"));
        methodSet.add(new ACSMethod("BeginDBTransaction", "null", "null"));
        methodSet.add(new ACSMethod("EndDBTransaction", "null", "null"));
        methodSet.add(new ACSMethod("GetDBEntries", "null", "null"));
        methodSet.add(new ACSMethod("CheckClass", "null", "null"));
        methodSet.add(new ACSMethod("DamageActor", "null", "null"));
        methodSet.add(new ACSMethod("SetActorFlag", "null", "null"));
        methodSet.add(new ACSMethod("SetTranslation", "null", "null"));
        methodSet.add(new ACSMethod("GetActorFloorTexture", "null", "null"));
        methodSet.add(new ACSMethod("GetActorFloorTerrain", "null", "null"));
        methodSet.add(new ACSMethod("StrArg", "null", "null"));
        methodSet.add(new ACSMethod("Floor", "null", "null"));
        methodSet.add(new ACSMethod("Round", "null", "null"));
        methodSet.add(new ACSMethod("Ceil", "null", "null"));
        methodSet.add(new ACSMethod("ScriptCall", "null", "null"));
        methodSet.add(new ACSMethod("StartSlideshow", "null", "null"));
        methodSet.add(new ACSMethod("GetSectorHealth", "null", "null"));
        methodSet.add(new ACSMethod("GetLineHealth", "null", "null"));
        methodSet.add(new ACSMethod("GetLineX", "null", "null"));
        methodSet.add(new ACSMethod("GetLineY", "null", "null"));
        methodSet.add(new ACSMethod("SetAirFriction", "null", "null"));
        methodSet.add(new ACSMethod("SetSectorGlow", "null", "null"));
        methodSet.add(new ACSMethod("SetFogDensity", "null", "null"));
        methodSet.add(new ACSMethod("GetTeamScore", "null", "null"));
        methodSet.add(new ACSMethod("SetTeamScore", "null", "null"));
        zspecialMethods = Collections.unmodifiableSet(methodSet);
    }

    public static boolean checkZpecialMethod(String methodName) {
        return zspecialMethods.stream().anyMatch(acsMethod -> acsMethod.getName().equalsIgnoreCase(methodName));
    }
}