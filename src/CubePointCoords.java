package src;

import src.Vec3;

public class CubePointCoords {

    // CUBESIZE
    final static float cs = 0.5f;
    // CUBE POINT COORDS ________________________________________________Point:
    final static Vec3 ppp = new Vec3(0.5f * cs, 0.5f * cs, 0.5f * cs);// ___ 0
    final static Vec3 Npp = new Vec3(-0.5f * cs, 0.5f * cs, 0.5f * cs);// ___1
    final static Vec3 pNp = new Vec3(0.5f * cs, -0.5f * cs, 0.5f * cs);// ___2
    final static Vec3 NNp = new Vec3(-0.5f * cs, -0.5f * cs, 0.5f * cs);// __3
    final static Vec3 NNN = new Vec3(-0.5f * cs, -0.5f * cs, -0.5f * cs);// _4
    final static Vec3 pNN = new Vec3(0.5f * cs, -0.5f * cs, -0.5f * cs);// __5
    final static Vec3 NpN = new Vec3(-0.5f * cs, 0.5f * cs, -0.5f * cs);// __6
    final static Vec3 ppN = new Vec3(0.5f * cs, 0.5f * cs, -0.5f * cs);// ___7

    // STATIC - DO NOT CREATE AN OBJECT CubePointCoords cube = new CubePoint... Vec3
    // corner = cube.ppp ... INSTEAD: CubePointCoords.ppp
}
