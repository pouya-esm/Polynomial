package Polynomial;

public class Mononomial {
	double power;
	double coeff;

	private String format(double value) {
		if (value==Math.floor(value) && !Double.isInfinite(value))
			return String.valueOf((long) value);
		return String.valueOf(value);
	}

	public String toString() {
		if (this.coeff>0 && this.power!=0)
			return ("+"+format(this.coeff)+"x^"+format(this.power));
		if (this.coeff>0 && this.power==0)
			return ("+"+format(this.coeff));
		if (this.coeff==0 && this.power==0)
			return String.valueOf(0);
		if (this.coeff<0 && this.power==0)
			return format(this.coeff);
		return (format(this.coeff)+"x^"+format(this.power));
	}
}
