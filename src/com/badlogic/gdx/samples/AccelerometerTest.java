/**
 *  This file is part of Libgdx by Mario Zechner (badlogicgames@gmail.com)
 *
 *  Libgdx is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Libgdx is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.badlogic.gdx.samples;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Mesh;
import com.badlogic.gdx.PerspectiveCamera;
import com.badlogic.gdx.RenderListener;
import com.badlogic.gdx.Mesh.PrimitiveType;

public class AccelerometerTest implements RenderListener 
{
	Mesh mesh;	
	PerspectiveCamera camera;

	@Override
	public void setup(Application application) 
	{
		camera = new PerspectiveCamera();
		camera.getPosition().set( 0, 0, 4 );
		camera.setFov( 90 );		
		
		mesh = application.newMesh( 3, false, false, false, false, 0, true );
		mesh.vertex( -0.5f, -0.5f, 0 );
		mesh.vertex( 0.5f, -0.5f, 0 );
		mesh.vertex( 0, 0.5f, 0 );
	}
	
	@Override
	public void render(Application application) 
	{
		application.clear( true, false, false );
		camera.setMatrices( application );
		application.rotate( 90 * application.getAccelerometerY() / 10, 0, 0, 1 );
		
		mesh.render(PrimitiveType.Triangles );
		
	}

	@Override
	public void dispose(Application application) {
		// TODO Auto-generated method stub
		
	}	
}
